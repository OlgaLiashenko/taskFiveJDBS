import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static Connection getDBConnection() {
        String url = "jdbc:postgresql://localhost:5432/gridbooks";
        String username = "postgres";
        String password = "";
        System.out.println("Connecting...");
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (
                SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } catch (
                ClassNotFoundException e) {
            System.out.println("Where is your JDBC Driver?");
            e.printStackTrace();
        }
        return connection;
    }
}
