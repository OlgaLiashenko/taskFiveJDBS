public class DataBaseProject {
    public static void main(String[] args) {

        // InsertIntoCustomers.executePreparedStatement();
        // InsertIntoShop.executePreparedStatement();
        // SelectFromTable.selectData();
        //  DeleteFromMultipleTables.deleteFromTable();
        // UpdateTable.update();
    }
}

//Connection interface. A Connection is the session between java application and database.
// The Connection interface provide many methods for transaction management like commit(), rollback() etc.
//By default, connection commits the changes after executing queries.

//Transaction represents a single unit of work.

//PreparedStatement  is used to execute parameterized query.

//Instead of executing a single query, we can execute a batch (group) of queries. It makes the performance fast.
//The java.sql.PreparedStatement interface provide methods for batch processing.