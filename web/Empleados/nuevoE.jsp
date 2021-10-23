<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NUEVO REGISTRO</title>
    </head>
    <body>
        <h2>Registro Nuevo Empleado</h2>
        <form action="EmpleadosController?accion=insertar"  method="POST" autocomplete="off">


            <p>
                Codigo del empleado:
                <input id="codigo" name="codigo" type="text"/>
            </p>

            <p>
                Nombre del empleado:
                <input id="nombre" name="nombre" type="text"/>
            </p>

            <p>
                Apellido del empleado:
                <input id="apellido" name="apellido" type="text"/>
            </p>

            <p>
                Cargo del empleado:
                <input id="cargo" name="cargo" type="text"/>
            </p>

            <br/><br/>

            <button id="guardar" name="guardar" type="submit">Guardar</button>


        </form>
    </body>
</html>
