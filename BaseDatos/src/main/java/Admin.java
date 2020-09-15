import java.sql.*;

public class Admin {


    public void addUsuario(Usuario usuario){
        Connection cnx;
        String urlCnx= "jdbc:postgresql://192.168.56.2/empresa";
        Statement sentencia;

        String nombre=usuario.getNombre();
        String apellido=usuario.getApellido();
        String departamento=usuario.getDepartamento();
        String sede=usuario.getSede();

        String sql="INSERT INTO usertable(nombre,apellidos,departamento,sede) VALUES('"+nombre+"','"+apellido+"','"+departamento+"','"+sede+"')";
        int insert;

        try{
            Class.forName("org.postgresql.Driver");
            cnx= DriverManager.getConnection(urlCnx,"postgres","abc");
            sentencia=cnx.createStatement();
            insert=sentencia.executeUpdate(sql);
            System.out.println("Se han insertado "+insert+" filas");

            cnx.close();
        }catch(ClassNotFoundException e){
            System.out.println("No encuentro la clase");
        }catch(SQLException e){
            System.out.println("Errror de SQL");
        }

    }

    public void showList(){
        Connection cn;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Clase cargada correctamente");
        }catch(ClassNotFoundException e){
            System.out.println("Error chungo: "+e.toString());
        }

        try {
            cn = DriverManager.getConnection("jdbc:postgresql://192.168.56.2/empresa", "postgres", "abc");
            String sql="SELECT * FROM usertable ORDER BY id";
            Statement sentencia= cn.createStatement();
            ResultSet filas=sentencia.executeQuery(sql);
            while(filas.next()){
                String id=filas.getString("id");
                String nombre=filas.getString("nombre");
                String apellidos=filas.getString("apellidos");
                String departamento=filas.getString("departamento");
                String sede=filas.getString("sede");
                System.out.println("ID: "+id);
                System.out.println("Nombre: "+nombre);
                System.out.println("Apellido: "+apellidos);
                System.out.println("Departamento: "+departamento);
                System.out.println("Sede: "+sede);
                System.out.println("");
            }
            System.out.println("Conexión establecida");
            cn.close();
        }catch(SQLException e){
            System.out.println("Error: " +e.toString());
        }

        System.out.println("Programa finalizado");

    }
    
}
