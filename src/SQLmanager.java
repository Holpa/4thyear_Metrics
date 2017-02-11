import java.sql.*; 
import java.sql.Connection;
import java.util.Random; 

public class SQLmanager{
	final private String host = "localhost:3306";
	final private String user = "root";
	final private String passwd = "password";
	final private String database = "mysql";
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private int temperature;
	private int ram;
	private int load;
	private int disk;

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
	/**
	 * inserting data from the terminal to the mysql DB
	 * @throws Exception
	 */
	public void insertData() throws Exception{
		LinuxTerminal command= new LinuxTerminal();
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		statement = connect.createStatement();
		String query="insert into system_info (`load`, `ram`, `disk`, `temperature`) VALUES (?,?,?,?)";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setInt(1, answer);
		answer = rn.nextInt(10) + 1;
		preparedStatement.setInt(2, answer);
		answer = rn.nextInt(10) + 1;
		preparedStatement.setInt(3, answer);
		answer = rn.nextInt(10) + 1;
		preparedStatement.setInt(4, answer);
		answer = rn.nextInt(10) + 1;
		preparedStatement.execute();

	}

	public void readData() throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from mysql.system_info");
			while (resultSet.next()) {
				this.load = resultSet.getInt("load");
				this.ram = resultSet.getInt("ram");
				this.temperature = resultSet.getInt("temperature");
				this.disk = resultSet.getInt("disk");
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
	public int getDisValue() {
		return this.disk;
	}
	public int getTempValue() {
		
		return this.temperature;
	}
	public int getRamValue() {
		
		return this.ram;
	}
	public int getLoadValue() {
		
		return this.load;
	}


}
