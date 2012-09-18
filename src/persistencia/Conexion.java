package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private String dburl;
	private String driver;
	private boolean connected;
	private Connection connection;
	private boolean free;

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Conexion() {
		dburl = "jdbc:mysql://localhost/ISO2?user=root&password=pass";
		driver = "com.mysql.jdbc.Driver";
		connected = false;
		connection = null;
		free = true;
	}

	public void connect() throws SQLException {
		try {
			if (!connected) {
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					System.err
							.println("ERROR: no se ha encontrado el driver de mysql."
									+ " Ponlo bien!!!\n" + e.toString());
				}
				connection = DriverManager.getConnection(dburl);
				connected = true;
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void disconnect() throws SQLException {
		try {
			if (connected) {
				connected = false;
				connection.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void update(String query) throws SQLException {
		try {
			if (connected) {
				Statement st = connection.createStatement();
				st.executeUpdate(query);
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public ResultSet execute(String query) throws SQLException {
		ResultSet res = null;
		try {
			if (connected) {
				Statement st = connection.createStatement();
				res = st.executeQuery(query);
			}
		} catch (SQLException e) {
			throw e;
		}
		return res;
	}

}