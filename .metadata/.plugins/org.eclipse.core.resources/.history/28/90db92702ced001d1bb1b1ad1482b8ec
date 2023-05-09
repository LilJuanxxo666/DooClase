package co.edu.uco.publiuco.data.dao.factory.relational.sqlserver;

import java.sql.Connection;

import co.edu.uco.publiuco.crosscutting.utils.UtilSql;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.EstadoTipoRelacionInstitucionSqlServerDAO;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.TipoRelacionInstitucionSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory{
	
	private Connection connection;
	
	public SqlServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		//It's homework
		connection = null;
	}

	@Override
	public void cerrarConexion() {
		UtilSql.closeConnection(connection);
	}

	@Override
	public void iniciarTransaccion() {
		//It's homework
	}

	@Override
	public void confirmarTransaccion() {

		
	}

	@Override
	public void cancelarTransaccion() {
	}

	@Override
	public EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO() {
		return new EstadoTipoRelacionInstitucionSqlServerDAO(connection);
	}

	@Override
	public TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO() {
		return new TipoRelacionInstitucionSqlServerDAO(connection);
	}
	
}
