package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	

	private final String base = "cementerioconocoto";
	private final String user = "root";
	private final String password = "";
	private final String url = "jdbc:mysql://localhost:3306/" + base;

	private Connection miConexion = null;

	public Connection getConexion() {
		try {
			miConexion = DriverManager.getConnection(this.url, this.user, this.password);
			System.out.print("Hola");
		}catch(SQLException e) {
			System.err.println(e);
		}
		return miConexion;
	}
}
