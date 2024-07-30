import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.SQLException;

public class Signup extends JFrame {

    // private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
    //                                           "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    //  public static boolean isValidEmail(String email) {
    //     if (email == null) {
    //         return false;
    //     }
        
    //     Pattern pattern = Pattern.compile(EMAIL_REGEX);
    //     Matcher matcher = pattern.matcher(email);
    //     return matcher.matches();
    // }

    public Signup() {
        JFrame frame = new JFrame("Signup Page");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(150, 0, 150, 100));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField firstName = new JTextField("First Name");
        firstName.setPreferredSize(new Dimension(290, 40));
        firstName.setHorizontalAlignment(JTextField.CENTER);
        firstName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                firstName.setText("");
            }
        });

        JTextField lastName = new JTextField("Last Name");
        lastName.setPreferredSize(new Dimension(290, 40));
        lastName.setHorizontalAlignment(JTextField.CENTER);
        lastName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastName.setText("");
            }
        });

        JTextField emailText = new JTextField("Email");
        emailText.setPreferredSize(new Dimension(290, 40));
        emailText.setHorizontalAlignment(JTextField.CENTER);
        emailText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                emailText.setText("");
            }
        });

        JTextField userText = new JTextField("Username");
        userText.setPreferredSize(new Dimension(290, 40));
        userText.setHorizontalAlignment(JTextField.CENTER);
        userText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userText.setText("");
            }
        });

        JPasswordField passwordText = new JPasswordField("");
        passwordText.setText("Password");
        passwordText.setPreferredSize(new Dimension(290, 40));
        passwordText.setHorizontalAlignment(JTextField.CENTER);
        passwordText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                passwordText.setText("");
            }
        });

        JPasswordField confirmPasswordText = new JPasswordField("Confirm Password");
        confirmPasswordText.setPreferredSize(new Dimension(290, 40));
        confirmPasswordText.setHorizontalAlignment(JTextField.CENTER);
        confirmPasswordText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                confirmPasswordText.setText("");
            }
        });
        
        JButton signupButton = new JButton("SIGN UP");
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
                Database database=new Database(); 
                String fName = firstName.getText();
                String lName = lastName.getText();
                String email = emailText.getText();
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());

                if(fName!=null && !fName.trim().isEmpty() && lName!=null && !lName.trim().isEmpty() && email!=null && !email.trim().isEmpty() 
                && username!=null && !username.trim().isEmpty() && password!=null && !password.trim().isEmpty() && confirmPassword!=null && !confirmPassword.trim().isEmpty()){
                    if(!email.contains("@")){
                        JOptionPane.showMessageDialog(null, "INVALID EMAIL");
                    } else{
                        try{
                            database.signUser(fName, lName, email, username,password);
                        }catch( SQLException e1){
                            e1.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "SUCCESSFULLY REGISTERED");     
                        new App();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "TEXT FIELD CANNOT BE LEFT EMPTY");     

                }
               
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
