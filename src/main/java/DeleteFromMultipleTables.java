import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromMultipleTables {

    public static void deleteFromTable() {

        String deleteRecord = "DELETE FROM customers USING book_shop  WHERE customers.id=book_shop.customer_id " +
                "AND customers.city = 'Paris'";

        try (Connection connection = CreateConnection.getDBConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteRecord)) {

            connection.setAutoCommit(false);

            pstmt.addBatch();

            int count[] = pstmt.executeBatch();

            connection.commit();

            System.out.println("record(s) deleted.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}