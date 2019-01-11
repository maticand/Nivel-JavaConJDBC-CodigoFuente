package conexionjdbc;

import java.sql.*;  

public class ConexionJDBC {

    public static void main(String[] args) {
        //Cadena de conexión de MySql, el parametro useSSL es opcional
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        // Cargamos el driver de mysql
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Creamos el objeto conexion
            Connection conexion = (Connection) DriverManager.getConnection(url, "matias", "some_pass");
            // Creamos un objeto Statement
            Statement instruccion = conexion.createStatement();
            //Creamos el query
            String sql = "SELECT id_persona, nombre, apellido FROM persona";
            ResultSet result = instruccion.executeQuery(sql);
            while (result.next()) {
                System.out.println("Id: " + result.getInt(1));
                System.out.println("Nombre: " + result.getString(2));
                System.out.println("Apellido: " + result.getString(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
