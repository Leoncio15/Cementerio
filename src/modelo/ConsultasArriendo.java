package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasArriendo extends Conexion {
	public boolean resgistrar(Arriendo arriendo) {

		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "INSERT INTO arriendo (observaciones_arriendo, id_nicho) VALUES(?,?)";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setString(1, arriendo.getObservaciones());
			miPreparedStatement.setInt(2, arriendo.getId_nicho());
		

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

	public boolean modificar(Arriendo arriendo) {
		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "UPDATE arriendo SET observaciones_arriendo=?, id_nicho=? WHERE id_arriendo=?";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setString(1, arriendo.getObservaciones());
			miPreparedStatement.setInt(2, arriendo.getId_nicho());
			miPreparedStatement.setInt(3, arriendo.getId());
		

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
	
	public boolean eliminar(Arriendo arriendo) {
		PreparedStatement miPreparedStatement = null;

		Connection miConexion = getConexion();

		String sql = "DELETE FROM arriendo WHERE id_arriendo = ?";

		try {
			miPreparedStatement = miConexion.prepareStatement(sql);

			miPreparedStatement.setInt(1, arriendo.getId());

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
	
	public boolean buscar(Arriendo arriendo) {
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM arriendo WHERE id_arriendo = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			

			miPreparedStatement.setInt(1, arriendo.getId());
			
			rs = miPreparedStatement.executeQuery();
			
			if(rs.next()) {
				arriendo.setObservaciones(rs.getString("observaciones_arrendamiento"));
				arriendo.setId_nicho(rs.getInt("id_nicho"));
				
				
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
	
	public boolean obtenerIdArreindo(Arriendo arriendo) {
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM arriendo ORDER BY id_arriendo DESC limit 1";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			rs = miPreparedStatement.executeQuery();
			
			if(rs.next()) {
				arriendo.setId(rs.getInt("id_arriendo"));
				arriendo.setObservaciones(rs.getString("observaciones_arriendo"));
				arriendo.setId_nicho(rs.getInt("id_nicho"));
				
				
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
	
	
 
	public ResultSet listarArriendos() {

		PreparedStatement miPreparedStatement = null;

		ResultSet rs = null;

		Connection miConexion = getConexion();

		String sql = "SELECT * FROM arriendo "
				+ "INNER JOIN contrato ON arriendo.id_arriendo = contrato.id_arriendo "
				+ "INNER JOIN responsable ON responsable.id_responsable = contrato.id_responsable "
				+ "INNER JOIN difunto ON difunto.id_difunto = contrato.id_difunto "
				+ "INNER JOIN nicho ON nicho.id_nicho = arriendo.id_nicho "
				+ "INNER JOIN seccion ON seccion.id_seccion = nicho.id_seccion";

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
