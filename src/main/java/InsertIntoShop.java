import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoShop {
    public static void executePreparedStatement() {

        String input = "INSERT INTO book_shop (transaction_id, customer_id, book_id, issue_date)"
                + "VALUES(?, ?, ?, ?)";

        try (Connection connection = CreateConnection.getDBConnection();
             PreparedStatement pstmt = connection.prepareStatement(input)) {

            //Set auto-commit to false
            connection.setAutoCommit(false);
/*
            // Set the variables
            pstmt.setInt( 1, 7);
            pstmt.setInt( 2, 6);
            pstmt.setInt( 3, 3);
            pstmt.setDate( 4, Date.valueOf("2018-08-25"));
            // Add it to the batch
            pstmt.addBatch();

            // Set the variables
            pstmt.setInt( 1, 8);
            pstmt.setInt( 2, 8);
            pstmt.setInt( 3, 1);
            pstmt.setDate( 4, Date.valueOf("2019-01-05"));
            // Add it to the batch
            pstmt.addBatch();

 */

            // Set the variables
            pstmt.setInt(1, 3);
            pstmt.setInt(2, 3);
            pstmt.setInt(3, 1);
            pstmt.setDate(4, Date.valueOf("2019-05-06"));
            // Add it to the batch
            pstmt.addBatch();


            // Set the variables
            pstmt.setInt(1, 4);
            pstmt.setInt(2, 3);
            pstmt.setInt(3, 2);
            pstmt.setDate(4, Date.valueOf("2018-06-29"));
            // Add it to the batch
            pstmt.addBatch();

            //Create an int[] to hold returned values
            int[] count = pstmt.executeBatch();

            //Explicitly commit statements to apply changes
            connection.commit();

            System.out.println("record(s) inserted into book_shop.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
