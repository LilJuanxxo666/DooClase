package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;

public class PostgreSqlDAOFactory extends DAOFactory{
	
	private Connection conexion;
	private static final String url = "jdbc:postgresql://localhost:5432/teqvim";
	private static final String usuario = "postgres";
    private static final String contraseña = "admin123";

	@Override
	protected void abrirConexion() {
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexion exitosa");
		}catch(SQLException e){
			e.getMessage();
		}
	}

	@Override
	public void cerrarConexion() {
		try {
			conexion.close();
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public void iniciarTransaccion() {
		
	}

	@Override
	public void confirmarTransaccion() {
		
	}

	@Override
	public void cancelarTransaccion() {
		
	}

	@Override
	public EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO() {
		return null;
	}

	@Override
	public TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		PostgreSqlDAOFactory base = new PostgreSqlDAOFactory();
		base.abrirConexion();
	}
}
