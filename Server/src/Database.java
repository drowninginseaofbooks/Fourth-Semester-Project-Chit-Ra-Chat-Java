
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database{
   
    String URL = "jdbc:mysql://localhost:3306/ChitRaChat_DB";
    String db_user = "root";
    String db_password = "Animefreak@jiyagun1";
    private Statement statement;
    User user;
    Connection conn;
        

    public Database(){
        try {
            try {
                //loading the driver to the sql
                Class.forName("com.mysql.cj.jdbc.Driver");
            } 

            catch (ClassNotFoundException e) 
            {
                e.printStackTrace();
            }

          //creating connection to betn sql database and driver
          conn=DriverManager.getConnection(URL, db_user, db_password);
            
        } 

        catch (SQLException e) 
        {
       
           e.printStackTrace();
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
            return true;   
            }
        }
        return false; 
    }

}