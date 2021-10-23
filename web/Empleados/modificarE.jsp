<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MODIFICAR REGISTRO</title>
    </head>
    <body>
        <h2>Modificar Registro Empleado</h2>
        <form action="EmpleadosController?accion=actualizar"  method="POST" autocomplete="off">
            
            <input id="id" name="id" type="hidden" value="<c:out value="${empleado.id}"/>"/>

            <p>
                Codigo del empleado:
                <input id="codigo_empleado" name="codigo_empleado" type="text" value="<c:out value="${empleado.codigo_empleado}"/>"/>
            </p>

            <p>
                Nombre del empleado:
                <input id="nombre_empleado" name="nombre_empleado" type="text" value="<c:out value="${empleado.nombre_empleado}"/>"/>
            </p>

            <p>
                Apellido del empleado:
                <input id="apellido_empleado" name="apellido_empleado" type="text" value="<c:out value="${empleado.apellido_empleado}"/>"/>
            </p>

            <p>
                Cargo del empleado:
                <input id="cargo" name="cargo" type="text" value="<c:out value="${empleado.cargo}"/>"/>
            </p>

            <br/><br/>

            <button id="guardar" name="guardar" type="submit">Guardar</button>


        </form>
    </body>
</html>
