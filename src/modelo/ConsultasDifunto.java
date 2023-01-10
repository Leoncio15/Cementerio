package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

public class ConsultasDifunto extends Conexion {
	
	public boolean registrar(Difunto difunto) {
		PreparedStatement miPreparedStatement = null;
		
		Connection miConexion = getConexion();
		
		String sql = "INSERT INTO difunto (cedula_difunto, nombre_difunto, apellido_difunto, edad_difunto, genero_difunto, fechaNacimiento_difunto,"
				+ "fechaFallecimiento_difunto) VALUES (?,?,?,?,?,?,?)";
		
		try {
			
			miPreparedStatement = miConexion.prepareStatement(sql);
			
			miPreparedStatement.setString(1, difunto.getCedula());
			miPreparedStatement.setString(2, difunto.getNombre());
			miPreparedStatement.setString(3, difunto.getApellido());
			miPreparedStatement.setInt(4, difunto.getEdad());
			miPreparedStatement.setString(5, difunto.getGenero());
			miPreparedStatement.setDate(6, (Date) difunto.getFechaNacimiento());
			miPreparedStatement.setDate(7, (Date) difunto.getFechaFallecimiento());
			
			
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
	
	public boolean modificar(Difunto difunto) {
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
	}
	
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
