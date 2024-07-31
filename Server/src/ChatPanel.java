import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatPanel extends JFrame {

    static Database db = new Database();

    static String msgIn = "";
    static String msgOut = "";
    static String username = db.username;

    static ServerSocket ss;
    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dos;

    static JTextField textField;
    static JFrame frame;
    static JButton send;
    static JTextArea textArea;

    ChatPanel() {
        super();
        // Create a new JFrame
        frame = new JFrame("Chit-Ra Chat(Server)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Create a JTextArea with specified width and height
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Wrap the JTextArea in a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add a DocumentListener to the JTextArea to make the scroll bar follow the
        // text
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateScrollBar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateScrollBar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateScrollBar();
            }

            private void updateScrollBar() {
                // Update the caret position and revalidate the scroll pane
                textArea.setCaretPosition(textArea.getDocument().getLength());
                scrollPane.revalidate();
                scrollPane.repaint();
            }
        });

        // Create a JPanel to hold the JTextField and JButton
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create a new JTextField with specified width and height
        textField = new JTextField("Enter Your Message");
        textField.setPreferredSize(new Dimension(680, 30));

        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });

        // Create a new JButton
        send = new JButton("SEND");

        // Add action listener to the button
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Append text to the JTextArea
                msgIn = textField.getText();
                msgOut = textField.getText();
                try {
                    dos.writeUTF(msgIn);
                } catch (IOException e1) {

                    e1.printStackTrace();
                }
                textField.setText("");
            }
        });

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // System.out.println("You Have Pressed A Key");
                    msgIn = textField.getText();
                    msgOut = textField.getText();
                    try {
                        dos.writeUTF(msgOut);
                    } catch (IOException e1) {

                        e1.printStackTrace();
                    }
                    textField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });

        JButton paint = new JButton("PAINT");

        paint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paint canvas = new Paint();
                frame.add(canvas);
            }
        });

        // Add the JTextField and JButton to the panel
        panel.add(textField);
        panel.add(send);
        panel.add(paint, BorderLayout.NORTH);

        // Add the JScrollPane (which contains the JTextArea) to the center of the
        // JFrame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the bottom of the JFrame
        frame.add(panel, BorderLayout.SOUTH);

        // Make the JFrame visible
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatPanel();
            }
        });
        try {
            ss = new ServerSocket(1201);
            s = ss.accept();
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Connect");
        }

        while (true) {
            msgIn = dis.readUTF();
            textArea.setText(textArea.getText() + "\nronan2248" + ": " + msgIn);
        }
    }
}
