package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;

public class DbConfig {
	private String dbUrl;
	private String dbLocation;
	private String dbUser;
	private String dbPassword;
	private String dbName;
	private String dbTable;
	private Connection dbConnection;
	
	public DbConfig() {
		super();
		
		Properties configuration;
		try {
			configuration = new Properties();
			InputStream stream = this.getClass().getResourceAsStream("/configuration/config.properties");
			configuration.load(stream);
			dbLocation = configuration.getProperty("dbLocation");
			dbUser = configuration.getProperty("dbUser");
			dbPassword = configuration.getProperty("dbPassword");
			dbName = configuration.getProperty("dbName");
		} catch (IOException iex) {
			iex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		dbUrl = dbLocation + dbName;
	}
	
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbLocation() {
		return dbLocation;
	}
	public void setDbLocation(String dbLocation) {
		this.dbLocation = dbLocation;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbTable() {
		return dbTable;
	}
	public void setDbTable(String dbTable) {
		this.dbTable = dbTable;
	}
	public Connection getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public void StartConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			dbConnection = (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void StopConnection() {
		try {
			dbConnection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
