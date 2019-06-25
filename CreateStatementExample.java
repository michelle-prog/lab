import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatementExample{
	
	private static final String createTableSQL = "create table Users1(\r\n" + 
	"id int(3) primary key,\r\n "+
	"name varchar(20),\r\n" + " email varchar(20),\r\n" +
	"country varchar(20),\r\n"+
	"password varchar(20)\r\n" + " );";



 public static void main(String[] args) throws SQLException{
 CreateStatementExample createTableExample = new CreateStatementExample();
 createTableExample.createTable();
 }

 public void createTable() throws SQLException{

 	System.out.println(createTableSQL);
 	try (Connection connection = DriverManager
 	.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");

 	Statement statement = connection.createStatement();){
 	statement.execute(createTableSQL);	
 	}  catch (SQLException e){
 		printSQLException(e);
 	}
 }
 

 public  static void printSQLException(SQLException ex){
 	for(Throwable e: ex){
 		if (e instanceof SQLException){
 			e.printStackTrace(System.err);
 			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
 			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
 		}
 	}
 }
}
}