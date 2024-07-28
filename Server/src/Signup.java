import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Signup extends JFrame {

    public Signup() {
        JFrame frame = new JFrame("Signup Page");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(150, 0, 150, 100));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField firstName = new JTextField("FirstName");
        firstName.setPreferredSize(new Dimension(290, 40));
        firstName.setHorizontalAlignment(JTextField.CENTER);

        JTextField lastName = new JTextField("LastName");
        lastName.setPreferredSize(new Dimension(290, 40));
        lastName.setHorizontalAlignment(JTextField.CENTER);

        JTextField emailText = new JTextField("Email");
        emailText.setPreferredSize(new Dimension(290, 40));
        emailText.setHorizontalAlignment(JTextField.CENTER);

        JTextField userText = new JTextField("Username");
        userText.setPreferredSize(new Dimension(290, 40));
        userText.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField passwordText = new JPasswordField("Password");
        passwordText.setPreferredSize(new Dimension(290, 40));
        passwordText.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField confirmPasswordText = new JPasswordField("Confirm password");
        confirmPasswordText.setPreferredSize(new Dimension(290, 40));
        confirmPasswordText.setHorizontalAlignment(JTextField.CENTER);
        
        JButton signupButton = new JButton("Signup");
        signupButton.setPreferredSize(new Dimension(200, 30)); // Set the preferred size for the button
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(firstName);
        // Add spacing between components
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(lastName);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailText);
        panel.add(Box.createVerticalStrut(10));
        panel.add(userText);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordText);
        panel.add(Box.createVerticalStrut(10));
        panel.add(confirmPasswordText);
        panel.add(Box.createVerticalStrut(20));
        panel.add(signupButton);

        frame.add(panel, BorderLayout.EAST);

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fName = firstName.getText();
                String lName = lastName.getText();
                String email = emailText.getText();
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY REGISTERED");
            }
        });

        JPanel leftPanel = new JPanel(new GridLayout(6, 1, 10, 20));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(250, 30, 10, 0));
        leftPanel.setBackground(new Color(255, 203, 205)); // Custom background color
        leftPanel.setOpaque(true); // Ensure the background color is visible
        leftPanel.setPreferredSize(new Dimension(520, frame.getHeight())); // Set the preferred size
        JLabel welcome = new JLabel("<html><h1>HELLO, FRIEND!</h1></html>", 10, Color.WHITE, Font.BOLD);
        JLabel welcome1 = new JLabel("<html><h1>ENTER YOUR DETAILS<br> AND START JOURNEY WITH US!</h1></html>", 10, Color.WHITE, Font.BOLD);

        leftPanel.add(welcome, BorderLayout.CENTER);
        leftPanel.add(welcome1, BorderLayout.WEST);

        frame.add(leftPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }

    public class JTextField extends javax.swing.JTextField {
        private Shape shape;
        private String hint;

        public JTextField(String hint) {
            super();
            this.hint = hint;
            setFont(new Font("Sergoe UI", Font.BOLD, 20));
            setOpaque(false);
            setText(hint);
            setForeground(Color.GRAY);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals("")) {
                        setText(hint);
                        setForeground(Color.GRAY);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().equals(hint)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }
            });
        }

        // For rounded corners
        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 45, 45);
            super.paintComponent(g);
        }

        // For rounded border
        protected void paintBorder(Graphics g) {
            g.setColor(Color.white);
            g.drawRoundRect(0, 0, getWidth(), getHeight(), 45, 45);
        }

        public boolean contains(int x, int y) {
            if (shape == null || shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 45, 45);
            }
            return shape.contains(x, y);
        }
    }

    public class JPasswordField extends javax.swing.JPasswordField {
        private Shape shape;
        private String hint;

        public JPasswordField(String hint) {
            super();
            this.hint = hint;
            setFont(new Font("Sergoe UI", Font.BOLD, 20));
            setOpaque(false);
            setText(hint);
            setForeground(Color.GRAY);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getPassword().equals("")) {
                        setText(hint);
                        setForeground(Color.GRAY);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getPassword().equals(hint)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }
            });
        }

        // For rounded corners
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 45, 45);
            super.paintComponent(g);
        }

        // For rounded border
        protected void paintBorder(Graphics g) {
            g.setColor(Color.white);
            g.drawRoundRect(0, 0, getWidth(), getHeight(), 45, 45);
        }

        public boolean contains(int x, int y) {
            if (shape == null || shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 45, 45);
            }
            return shape.contains(x, y);
        }
    }

    public class JLabel extends javax.swing.JLabel {
        public JLabel(String text, int textSize, Color color, int style) {
            setFont(new Font("Sergoe UI", style, textSize));
            setText(text);
            setForeground(color);
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
