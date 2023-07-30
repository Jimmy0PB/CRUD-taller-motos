package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatebaseUtil {
    public static Connection getConnection() throws SQLException {
        // Información de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/bd_crud_taller";
        String user = "root";
        String password = "";

        // Establecer la conexión
        return DriverManager.getConnection(url, user, password);
    }
    //Cerrar conexion
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if(connection != null){
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
