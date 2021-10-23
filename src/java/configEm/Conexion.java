package configEm;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection getConexion() {

        try {
            
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantekarol?serverTimezone=UTC", "root", "123456");
            System.out.println("Conexion exitosa");
            return conexion;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }

}
