package modeloEm;

public class Empleados {
    
    private int id;
    private String codigo_empleado;
    private String nombre_empeado;
    private String apellido_empleado;
    private String cargo;

    public Empleados(int id, String codigo_empleado, String nombre_empeado, String apellido_empleado, String cargo) {
        this.id = id;
        this.codigo_empleado = codigo_empleado;
        this.nombre_empeado = nombre_empeado;
        this.apellido_empleado = apellido_empleado;
        this.cargo = cargo;
    }

    public Empleados(String codigo_empleado, String nombre_empleado, String apellido_empleado, String cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombre_empeado() {
        return nombre_empeado;
    }

    public void setNombre_empeado(String nombre_empeado) {
        this.nombre_empeado = nombre_empeado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
