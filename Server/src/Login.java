
    import java.awt.*;

//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;



public class Login extends JFrame {
    

    public Login()
    {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(250, 0, 250, 100));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JTextField userText = new JTextField("            Username");
        userText.setPreferredSize(new Dimension(290, 50));
        JPasswordField passwordText = new JPasswordField("Password");
        passwordText.setPreferredSize(new Dimension(290, 50));
        JButton signupButton = new JButton("Login");
        signupButton.setPreferredSize(new Dimension(200, 30)); // Set the preferred size for the button
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add spacing between components
        panel.add(Box.createVerticalStrut(10));    
        panel.add(Box.createVerticalStrut(10));
        panel.add(userText);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordText);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalStrut(20));
        panel.add(signupButton);

        frame.add(panel, BorderLayout.EAST);

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String userName1 = userText.getText();
                String password = new String(passwordText.getPassword());
                JOptionPane.showMessageDialog(panel,"Login clicked");
            }
        });

        


       JPanel leftpanel = new JPanel(new GridLayout(6,1,10,20));
        leftpanel.setBorder(BorderFactory.createEmptyBorder(250, 30, 100, 0));
        leftpanel.setBackground(new Color(255, 203, 205)); // Custom background color
        leftpanel.setOpaque(true); // Ensure the background color is visible
        leftpanel.setPreferredSize(new Dimension(520, frame.getHeight())); // Set the preferred size
        JLabel welcome = new JLabel("Welcome Back!",40,Color.WHITE,Font.BOLD);
        JLabel welcome1= new JLabel("To keep connected with us please login",20,Color.WHITE,Font.BOLD);
       

       
        leftpanel.add(welcome,BorderLayout.CENTER);
        leftpanel.add(welcome1,BorderLayout.WEST);

      

       frame.add(leftpanel,BorderLayout.WEST);


        frame.setVisible(true);

    }

    

    public class JTextField extends javax.swing.JTextField  {
        private Shape shape;
         private String hint;
     
         public JTextField(String hint){
             super();
             this.hint = hint;
             setFont(new Font("Sergeo UI",Font.BOLD,20));
             setOpaque(false);
             setText(hint);
             setForeground(Color.BLUE);
             setBorder(BorderFactory.createEmptyBorder(TOP,5,BOTTOM,5));
             addFocusListener(new FocusListener() {
                 @Override
                 public void focusGained(FocusEvent e) {
                     if(getText().equals("")){
                         setText(hint);
                         setForeground(Color.BLUE);
                     }
                 }
     
                 @Override
                 public void focusLost(FocusEvent e) {
                     if(getText().equals(hint)){
                         setText("");
                         setForeground(Color.BLACK);
                     }
                 }
             });
         }
     
         //for rounded courners
         protected void paintComponent(Graphics g){
             g.setColor(Color.white);
             g.fillRoundRect(0,0,getWidth(), getHeight(), 45, 45);
             super.paintComponent(g);
         }
     
         //for rounded border
         protected void paintBorder(Graphics g){
             g.setColor(Color.white);
             g.drawRoundRect(0,0,getWidth(), getHeight(), 45, 45);
         }
     
         public boolean contains(int x, int y){
             if(shape == null || shape.getBounds().equals(getBounds())){
                 shape = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),45,45);
             }
             return shape.contains(x,y);
         }
     
     }

      
     public class JPasswordField extends javax.swing.JPasswordField  {
        private Shape shape;
         private String hint;
     
         public JPasswordField(String hint){
             super();
             this.hint = hint;
             setFont(new Font("Sergeo UI",Font.BOLD,20));
             setOpaque(false);
             setText(hint);
             setForeground(Color.BLUE);
             setBorder(BorderFactory.createEmptyBorder(TOP,5,BOTTOM,5));
             addFocusListener(new FocusListener() {
                 @Override
                 public void focusGained(FocusEvent e) {
                     if(getText().equals("")){
                         setText(hint);
                         setForeground(Color.BLUE);
                     }
                 }
     
                 @Override
                 public void focusLost(FocusEvent e) {
                     if(getText().equals(hint)){
                         setText("");
                         setForeground(Color.BLACK);
                     }
                 }
             });
         }
     
         //for rounded corners
         protected void paintComponent(Graphics g){
             g.setColor(Color.WHITE);
             g.fillRoundRect(0,0,getWidth(), getHeight(), 45, 45);
             super.paintComponent(g);
         }
     
         //for rounded border
         protected void paintBorder(Graphics g){
             g.setColor(Color.white);
             g.drawRoundRect(0,0,getWidth(), getHeight(), 45, 45);
         }
     
         public boolean contains(int x, int y){
             if(shape == null || shape.getBounds().equals(getBounds())){
                 shape = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),45,45);
             }
             return shape.contains(x,y);
         }
     
    } 


     public class JLabel extends javax.swing.JLabel {
    public JLabel(String text, int textSize, Color color, int style){
        setFont(new Font("Sergoe UI", style, textSize));
        setText(text);
        setForeground(color);
       }
    }

     public static void main(String[] args) {
        new Login();
     }





}

