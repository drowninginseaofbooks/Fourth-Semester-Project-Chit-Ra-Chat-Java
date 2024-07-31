import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database{

    String username;
   
    private String URL = "jdbc:mysql://localhost:3306/ChitRaChat_DB";
    private String db_user = "root";
    private String db_password = "Animefreak@jiyagun1";
    private Statement statement;
    // User user;
    private Connection conn;
        

    public Database(){
            try {
                // Example for MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, db_user, db_password);
            } catch (ClassNotFoundException e) {
                System.out.println("Database driver not found.");
                // e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Failed to establish a database connection.");
                // e.printStackTrace();
            }
} 

    public void signUser(String firstName, String lastName, String email, String userName,String password) throws SQLException
    {
        PreparedStatement insertStatement= conn.prepareStatement("INSERT into USERS_TB (FirstName,LastName,Email,UserName,Password) values (?,?,?,?,?)");
        insertStatement.setString(1, firstName);
        insertStatement.setString(2, lastName);
        insertStatement.setString(3, email);
        insertStatement.setString(4, userName);
        insertStatement.setString(5, password);
        insertStatement.executeUpdate();

    }

    public boolean loginUser(String email, String password) throws SQLException
    {
        PreparedStatement viewStatement = conn.prepareStatement("SELECT * FROM USERS_TB");
        ResultSet rs = viewStatement.executeQuery();
        while (rs.next()) {
            if(((email.equals(rs.getString("Email"))) || email.equals(rs.getString("UserName"))) && password.equals(rs.getString("Password"))){
           //CODE TO MAIN PANEL
                this.username = rs.getString("UserName");
                return true;   
            }
        }
        return false; 
    }

    public Connection getConnection(){
        return conn;
    }

}