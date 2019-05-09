import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {
    public static void update() {
        String updateTable = "UPDATE book_library SET number_of_pages = 1100 WHERE book_id = 4";

        try (Connection connection = CreateConnection.getDBConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateTable)) {

            connection.setAutoCommit(false);

            pstmt.addBatch();

            int count[] = pstmt.executeBatch();

            connection.commit();

            System.out.println("record(s) updated.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
