import java.sql.*;

public class Conexion {

    Connection cn;


    public void connect(){

        try{
            Class.forName("org.postgresql.Driver");
            cn= DriverManager.getConnection("jdbc:postgresql://192.168.56.2/empresa", "postgres", "abc");
            System.out.println("Conexión establecida.");

        }catch(ClassNotFoundException e) {
            System.out.println("No encuentro la clase");
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }


    }


}
