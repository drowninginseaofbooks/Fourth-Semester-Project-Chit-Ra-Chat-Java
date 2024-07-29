import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
   
  
       
    String URL = "jdbc:mysql://localhost:3306/chit-ra-chat";
    String db_user = "root";
    String db_password = "@s*Omu12";
    private Statement statement;
    Connection conn;
            
    
    public Database(){

            try 
            {
                //loading the driver to the sql
                Class.forName("com.mysql.cj.jdbc.Driver");
            } 

            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
}



      



