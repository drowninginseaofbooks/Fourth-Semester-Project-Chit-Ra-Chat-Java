import java.sql.Connection;

public class Database {
   
  
       
    String URL = "jdbc:mysql://localhost:3306/chit-ra-chat";
    String db_user = "root";
    String db_password = "@s*Omu12";
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
            

       