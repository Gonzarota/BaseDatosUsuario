public class Usuario {

    private String nombre;
    private String apellido;
    private String departamento;
    private String sede;


    public Usuario(String nombre, String apellido, String departamento, String sede){
        this.nombre=nombre;
        this.apellido=apellido;
        this.departamento=departamento;
        this.sede=sede;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getSede() {
        return sede;
    }
}
