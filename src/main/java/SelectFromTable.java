import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectFromTable {
    public static void selectData() {
        String selectFromGridbooks = "SELECT author, title, year_of_publication FROM book_library";

        try (Connection connection = CreateConnection.getDBConnection();
             PreparedStatement pstm = connection.prepareStatement(selectFromGridbooks);
             ResultSet selected = pstm.executeQuery()) {

            while (selected.next()) {
                String author = selected.getString("author");
                String title = selected.getString("title");
                int year = selected.getInt("year_of_publication");

                System.out.println(author + " '" + title + "' " + year);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}