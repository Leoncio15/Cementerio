package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasNicho extends Conexion {

	public boolean resgistrar(Nicho nicho) {

		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "INSERT INTO nicho (numero_nicho, tipo_nicho, estado_nicho, id_seccion) VALUES(?,?,?,?)";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setInt(1, nicho.getNumero());
			miPreparedStatement.setString(2, nicho.getTipo());
			miPreparedStatement.setString(3, nicho.getEstado());
			miPreparedStatement.setInt(4, nicho.getId_seccion());

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

	public boolean modificar(Nicho nicho) {
		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "UPDATE nicho SET numero_nicho=?, tipo_nicho=?, estado_nicho=?, id_seccion=? WHERE id_nicho=?";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setInt(1, nicho.getNumero());
			miPreparedStatement.setString(2, nicho.getTipo());
			miPreparedStatement.setString(3, nicho.getEstado());
			miPreparedStatement.setInt(4, nicho.getId_seccion());
			miPreparedStatement.setInt(5, nicho.getId());

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
	
	public boolean eliminar(Nicho nicho) {
		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "DELETE FROM seccion WHERE id_nicho = ?";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setInt(1, nicho.getId());

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
	
	public boolean buscar(Nicho nicho) {
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM seccion WHERE id_nicho = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			

			miPreparedStatement.setInt(1, nicho.getId());
			
			rs = miPreparedStatement.executeQuery();
			
			if(rs.next()) {
				nicho.setNumero(rs.getInt("numero_nicho"));
				nicho.setTipo(rs.getString("tipo_nicho"));
				nicho.setEstado(rs.getString("estado_nicho"));
				nicho.setId_seccion(rs.getInt("id_seccion"));
				
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

	public ResultSet listarNichos() {

		PreparedStatement miPreparedStatement = null;

		ResultSet rs = null;

		Connection miConexion = getConexion();

		String sql = "SELECT * FROM nicho INNER JOIN seccion on nicho.id_seccion = seccion.id_seccion";

		try {

			miPreparedStatement = miConexion.prepareStatement(sql);

			rs = miPreparedStatement.executeQuery();

			return rs;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
	
	public ResultSet listarNichosPorSeccion(int id) {

		PreparedStatement miPreparedStatement = null;

		ResultSet rs = null;

		Connection miConexion = getConexion();

		String sql = "SELECT * FROM nicho INNER JOIN seccion on nicho.id_seccion = seccion.id_seccion WHERE seccion.id_seccion = " + id;

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
