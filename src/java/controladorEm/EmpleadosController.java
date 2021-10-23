package controladorEm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloEm.Empleados;
import modeloEm.EmpleadosDAO;

@WebServlet(name = "EmpleadosController", urlPatterns = {"/EmpleadosController"})
public class EmpleadosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpleadosDAO empleadosDAO = new EmpleadosDAO();
        String accion;
        RequestDispatcher dispacher = null;

        accion = request.getParameter("accion");
        if (accion == null || accion.isEmpty()) {
            dispacher = request.getRequestDispatcher("Empleados/empleados.jsp");
            List<Empleados> listaEmpleados = empleadosDAO.listaEmpleados();
            request.setAttribute("lista", listaEmpleados);
        } else if ("nuevo".equals(accion)) {
            dispacher = request.getRequestDispatcher("Empleados/nuevo.jsp");
        } else if ("insertar".equals(accion)) {

            String codigo_empleado = request.getParameter("codigo_empleado");
            String nombre_empleado = request.getParameter("nombre_empleado");
            String apellido_empleado = request.getParameter("apellido_empleado");
            String cargo = request.getParameter("cargo");

            Empleados empleados = new Empleados(0, codigo_empleado, nombre_empleado, apellido_empleado, cargo);
            empleadosDAO.insertar(empleados);
            List<Empleados> listaEmpleados = empleadosDAO.listaEmpleados();
            request.setAttribute("lista", listaEmpleados);

            dispacher = request.getRequestDispatcher("Empleados/empleados.jsp");

        } else if ("modificar".equals(accion)) {
            dispacher = request.getRequestDispatcher("Empleados/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Empleados empleado = empleadosDAO.mostrarEmpleados(id);
            request.setAttribute("empleado", empleado);

        } else if ("actualizar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo_empleado = request.getParameter("codigo_empleado");
            String nombre_empleado = request.getParameter("nombre_empleado");
            String apellido_empleado = request.getParameter("apellido_empleado");
            String cargo = request.getParameter("cargo");

            Empleados empleados = new Empleados(id, codigo_empleado, nombre_empleado, apellido_empleado, cargo);
            empleadosDAO.actualizar(empleados);
            List<Empleados> listaEmpleados = empleadosDAO.listaEmpleados();
            request.setAttribute("lista", listaEmpleados);
            
        } else if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));

            empleadosDAO.eliminar(id);
            List<Empleados> listaEmpleados = empleadosDAO.listaEmpleados();
            request.setAttribute("lista", listaEmpleados);
        }else{
            dispacher = request.getRequestDispatcher("Empleados/empleados.jsp");
            List<Empleados> listaEmpleados = empleadosDAO.listaEmpleados();
            request.setAttribute("lista", listaEmpleados);
        }
        dispacher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
