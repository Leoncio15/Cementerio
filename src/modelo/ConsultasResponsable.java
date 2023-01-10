package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasResponsable extends Conexion {
	public boolean registrar(Responsable responsable) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "INSERT INTO responsable (cedula_responsable, nombre_responsable, apellido_responsable, telefono_responsable, parentesco_responsable) "
				+ "VALUES (?,?,?,?,?)";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			miPreparedStatement.setString(1, responsable.getCedula());
			miPreparedStatement.setString(2, responsable.getNombre());
			miPreparedStatement.setString(3, responsable.getApellido());
			miPreparedStatement.setString(4, responsable.getTelefono());
			miPreparedStatement.setString(5, responsable.getParentesco());
		
			
			miPreparedStatement.execute();
			
			return true;
			
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		} finally {
			try {
				miConexion.close();
			}catch(SQLException e) {
				System.err.println(e);		
			}
		}
	}
	
	public boolean modificar(Responsable responsable) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "UPDATE responsable SET nombre_responsable=?, apellido_responsable=?, telefono_responsable=?, parentesco_responsable=? WHERE cedula_responsable = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			
			
			miPreparedStatement.setString(1, responsable.getNombre());
			miPreparedStatement.setString(2, responsable.getApellido());
			miPreparedStatement.setString(3, responsable.getTelefono());
			miPreparedStatement.setString(4, responsable.getParentesco());
			miPreparedStatement.setString(5, responsable.getCedula());
			
			miPreparedStatement.execute();
			
			return true;
			
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
	
	public boolean eliminar(Responsable responsable) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "DELETE FROM responsable  WHERE cedula_responsable =?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			
			miPreparedStatement.setString(1, responsable.getCedula());
			
			miPreparedStatement.execute();
			
			return true;
			
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
	
	public boolean buscar(Responsable responsable) {
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM responsable WHERE cedula_responsable = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			

			miPreparedStatement.setString(1, responsable.getCedula());
			
			rs = miPreparedStatement.executeQuery();
			
			if(rs.next()) {
				responsable.setId(rs.getInt("id_responsable"));
				responsable.setCedula(rs.getString("cedula_responsable"));
				responsable.setNombre(rs.getString("nombre_responsable"));
				responsable.setApellido(rs.getString("apellido_responsable"));
				responsable.setTelefono(rs.getString("telefono_responsable"));
				responsable.setParentesco(rs.getString("parentesco_responsable"));
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
	
	public ResultSet listarResponsable(Responsable responsable) {
		
		//List<Difunto> difuntos = new ArrayList<>();
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM responsable";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			
			rs = miPreparedStatement.executeQuery();
			
		
			
			return rs;
			
		}catch(SQLException e) {
			System.err.println(e);
			return null;
		}
	}
}
