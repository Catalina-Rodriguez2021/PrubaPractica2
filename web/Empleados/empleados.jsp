<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>empleados</title>
    </head>
    <body>
        <h1>Bienvenidos</h1>

        <a href="EmpleadosController?accion=nuevo" >Nuevo Registro</a>
        <br/><br/>
        <table border="1" width="70%" > 
            <thead>
                <tr>
                    <th>Codigo del Empleado</th>
                    <th>Nombre del Empleado</th>
                    <th>Apellido del Empleado</th>
                    <th>Cargo del Empleado</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="empleado" items="${lista}">
                    <tr>
                        <td><c:out value="${empleado.codigo_empleado}" /> </td>
                        <td><c:out value="${empleado.nombre_empleado}" /> </td>
                        <td><c:out value="${empleado.apellido_empleado}" /> </td>
                        <td><c:out value="${empleado.cargo}" /> </td>
                        <td><a href="EmpleadosController?accion=modificar&id=<c:out value="${empleado.id}" />">Modificar</a></td>
                        <td><a href="EmpleadosController?accion=eliminar&id=<c:out value="${empleado.id}" />">Eliminar</a></td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
