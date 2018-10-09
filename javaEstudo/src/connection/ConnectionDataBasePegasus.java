package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDataBasePegasus {
	private static String banco = "jdbc:postgresql://172.16.0.152:5432/erp_pegasus?autoReconnect=true";
	private static String password = "$c13b3r#";
	private static String user = "cleber";
	private static Connection connection = null;

	static {
		conectar();
	}

	public ConnectionDataBasePegasus() {
		conectar();
	}

	private static void conectar() {
		try {

			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados"
					+ e.getMessage());
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
