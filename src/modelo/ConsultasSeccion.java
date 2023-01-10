package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasSeccion extends Conexion {

	public boolean resgistrar(Seccion seccion) {

		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "INSERT INTO seccion (nombre_seccion, descripcion_seccion) VALUES (?,?)";

		try {

			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setString(1, seccion.getNombre());
			miPreparedStatement.setString(2, seccion.getDescripcion());

			miPreparedStatement.execute();

			return true;

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}

	public boolean modificar(Seccion seccion) {
		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "UPDATE seccion SET nombre_seccion = ?, descripcion_seccion = ? WHERE id_seccion = ?";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setString(1, seccion.getNombre());
			miPreparedStatement.setString(2, seccion.getDescripcion());
			miPreparedStatement.setInt(3, seccion.getId());

			miPreparedStatement.execute();

			return true;

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public boolean eliminar(Seccion seccion) {
		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "DELETE FROM seccion WHERE id_seccion = ?";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setInt(1, seccion.getId());

			miPreparedStatement.execute();

			return true;

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	
	public boolean buscar(Seccion seccion) {
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM seccion WHERE id_seccion = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			

			miPreparedStatement.setInt(1, seccion.getId());
			
			rs = miPreparedStatement.executeQuery();
			
			if(rs.next()) {
				seccion.setNombre(rs.getString("nombre_seccion"));
				seccion.setDescripcion(rs.getString("descrpcion_seccion"));
				
				return true;
			}
			
			return false;
			
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				miConexion.close();
			}catch(SQLException e) {
				System.err.println(e);		
			}
		}
	}

	public ResultSet listarSecciones() {

		PreparedStatement miPreparedStatement = null;

		ResultSet rs = null;

		Connection miConexion = getConexion();

		String sql = "SELECT * FROM seccion ";

		try {

			miPreparedStatement = miConexion.prepareStatement(sql);

			rs = miPreparedStatement.executeQuery();

			return rs;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

}
