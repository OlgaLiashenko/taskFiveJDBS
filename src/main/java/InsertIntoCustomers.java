import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoCustomers {

    public static void executePreparedStatement() {

        String input = "INSERT INTO customers (id, firstname, lastname, city) " + "VALUES(?, ?, ?, ?)";

        try (Connection connection = CreateConnection.getDBConnection();
             PreparedStatement pstmt = connection.prepareStatement(input)) {

            //Set auto-commit to false
            connection.setAutoCommit(false);


            // Set the variables
            pstmt.setInt(1, 3);
            pstmt.setString(2, "Marc");
            pstmt.setString(3, "Pollo");
            pstmt.setString(4, "Paris");
            // Add it to the batch
            pstmt.addBatch();

/*
            // Set the variables
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Kate");
            pstmt.setString(3, "Middl");
            pstmt.setString(4, "London");
            // Add it to the batch
            pstmt.addBatch();

 */

            //Create an int[] to hold returned values
            int[] count = pstmt.executeBatch();

            //Explicitly commit statements to apply changes
            connection.commit();

            System.out.println("record(s) inserted into customers.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
