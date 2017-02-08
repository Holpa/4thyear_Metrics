import java.sql.*; 
import java.sql.Connection; 

public class SQLmanager{
	 private int value;
     private Connection connect = null;
     private Statement statement = null;
     private PreparedStatement preparedStatement = null;
     private ResultSet resultSet = null;

     final private String host = "localhost:3306";
     final private String user = "root";
     final private String passwd = "password";
     final private String database = "mysql";

     public void connectToDB() throws Exception {
             try {
                     // This will load the MySQL driver, each DB has its own driver
                     Class.forName("com.mysql.jdbc.Driver");

                     // Setup the connection with the DB
                     connect = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database,user,passwd);

             } catch (Exception e) {
                     throw e;
             }
     }
     public void insertData() throws Exception{
    	 statement = connect.createStatement();
    	 String query="insert into system_info (`load`, `ram`, `disk`, `temperature`) VALUES (?,?,?,?)";
    	 preparedStatement = connect.prepareStatement(query);
    	 preparedStatement.setInt(1, 6);
    	 preparedStatement.setInt(2, 7);
    	 preparedStatement.setInt(3, 8);
    	 preparedStatement.setInt(4, 9);
    	 preparedStatement.execute();
    	 
     }

     public void readData() throws Exception {
             try {
                     statement = connect.createStatement();
                     resultSet = statement
                                     .executeQuery("select * from mysql.system_info");
                     int iterator =0;
                     while (resultSet.next()) {
                             int Id = 99;
                             int name = resultSet.getInt("load");
                             int phone = resultSet.getInt("ram");
                             value = resultSet.getInt("temperature");
                             System.out.println(String.format(
                                             "Id: %d name: %5s  phone: %5s", Id, name, phone));
                     }
             } catch (Exception e) {
                     throw e;
             }
     }

     // You need to close the resultSet
     public void close() {
             try {
                     if (resultSet != null) {
                             resultSet.close();
                     }

                     if (statement != null) {
                             statement.close();
                     }

                     if (connect != null) {
                             connect.close();
                     }
             } catch (Exception e) {

             }
     }
	public int getValue() {
		return value;
	}

	
}
