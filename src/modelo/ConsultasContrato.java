package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasContrato extends Conexion {
	public boolean registrar(Contrato contrato) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "INSERT INTO contrato (numero_contrato, tipo_contrato, fechaInicio_contrato, fechaVencimiento_contrato, periodo_contrato, estado_contrato,"
				+ "documento_contrato, id_responsable, id_difunto, id_arriendo) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			miPreparedStatement.setInt(1, contrato.getNumero());
			miPreparedStatement.setString(2, contrato.getTipo());
			miPreparedStatement.setDate(3, (Date) contrato.getFechaInicio());
			miPreparedStatement.setDate(4, (Date) contrato.getFechaVencimiento());
			miPreparedStatement.setString(5, contrato.getPeriodo());
			miPreparedStatement.setString(6, contrato.getEstado());
			miPreparedStatement.setString(7, contrato.getDocumento());
			miPreparedStatement.setInt(8, contrato.getId_responsable());
			miPreparedStatement.setInt(9, contrato.getId_difunto());
			miPreparedStatement.setInt(10, contrato.getId_arriendo());
			
			
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
	
	/*public boolean modificar(Difunto difunto) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "UPDATE difunto SET nombre_difunto=?, apellido_difunto=?, edad_difunto=?, genero_difunto=?, "
				+ " fechaNacimiento_difunto=?, fechaFallecimiento_difunto=? WHERE cedula_difunto = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			
			miPreparedStatement.setString(1, difunto.getNombre());
			miPreparedStatement.setString(2, difunto.getApellido());
			miPreparedStatement.setInt(3, difunto.getEdad());
			miPreparedStatement.setString(4, difunto.getGenero());
			miPreparedStatement.setDate(5, (Date) difunto.getFechaNacimiento());
			miPreparedStatement.setDate(6, (Date) difunto.getFechaFallecimiento());
			miPreparedStatement.setString(7, difunto.getCedula());
			
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
	
	public boolean eliminar(Difunto difunto) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "DELETE FROM difunto  WHERE cedula_difunto =?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			
			miPreparedStatement.setString(1, difunto.getCedula());
			
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
	
	public boolean buscar(Difunto difunto) {
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM difunto WHERE cedula_difunto = ?";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			

			miPreparedStatement.setString(1, difunto.getCedula());
			
			rs = miPreparedStatement.executeQuery();
			
			if(rs.next()) {
				difunto.setId(rs.getInt("id_difunto"));
				difunto.setCedula(rs.getString("cedula_difunto"));
				difunto.setNombre(rs.getString("nombre_difunto"));
				difunto.setApellido(rs.getString("apellido_difunto"));
				difunto.setEdad(rs.getInt("edad_difunto"));
				difunto.setFechaFallecimiento(rs.getDate("fechaFallecimiento_difunto"));
				difunto.setGenero(rs.getString("genero_difunto"));
				difunto.setFechaNacimiento(rs.getDate("fechaNacimiento_difunto"));
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
	}*/
	
	public ResultSet listarDifuntos(Difunto difunto) {
		
		//List<Difunto> difuntos = new ArrayList<>();
		PreparedStatement miPreparedStatement = null;
		
		ResultSet rs = null;
		
		Connection miConexion = getConexion();
		
		String sql = "SELECT * FROM difunto";
		
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
