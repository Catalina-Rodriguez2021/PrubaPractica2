package modeloEm;

import configEm.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {

    Connection conexion;

    public EmpleadosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public List<Empleados> listaEmpleados() {

        PreparedStatement ps;
        ResultSet rs;
        List<Empleados> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT ID,CODIGO_EMPLEADO,NOMBRE_EMPLEADO,APELLIDO_EMPLEADO,CARGO FROM EMPLEADOS");
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String codigo_empleado = rs.getString("codigo_empleado");
                String nombre_empleado = rs.getString("nombre_empleado");
                String apellido_empleado = rs.getString("apellido_empleado");
                String cargo = rs.getString("cargo");

                Empleados empleado = new Empleados(id, codigo_empleado, nombre_empleado, apellido_empleado, cargo);

                lista.add(empleado);
            }
            return lista;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public Empleados mostrarEmpleados(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Empleados empleado = null;

        try {

            ps = conexion.prepareStatement("SELECT ID,CODIGO_EMPLEADO,NOMBRE_EMPLEADO,APELLIDO_EMPLEADO,CARGO FROM EMPLEADOS WHERE ID=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String codigo_empleado = rs.getString("codigo_empleado");
                String nombre_empleado = rs.getString("nombre_empleado");
                String apellido_empleado = rs.getString("apellido_empleado");
                String cargo = rs.getString("cargo");

                empleado = new Empleados(id, codigo_empleado, nombre_empleado, apellido_empleado, cargo);

            }
            return empleado;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean insertar(Empleados empleado) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO EMPLEADOS (CODIGO_EMPLEADO,NOMBRE_EMPLEADO,APELLIDO_EMPLEADO,CARGO)VALUES(?,?,?,?)");
            ps.setString(1, empleado.getCodigo_empleado());
            ps.setString(2, empleado.getNombre_empeado());
            ps.setString(3, empleado.getApellido_empleado());
            ps.setString(4, empleado.getCargo());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean actualizar(Empleados empleado) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE EMPLEADOS SET CODIGO_EMPLEADO=?,NOMBRE_EMPLEADO=?,APELLIDO_EMPLEADO=?,CARGO=? WHERE ID =?");
            ps.setString(1, empleado.getCodigo_empleado());
            ps.setString(2, empleado.getNombre_empeado());
            ps.setString(3, empleado.getApellido_empleado());
            ps.setString(4, empleado.getCargo());
            ps.setInt(5, empleado.getId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM EMPLEADOS WHERE ID =?");
            ps.setInt(1, _id);
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
