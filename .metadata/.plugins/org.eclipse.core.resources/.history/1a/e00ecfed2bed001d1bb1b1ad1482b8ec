package co.edu.uco.publiuco.data.dao.factory;

import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.relational.postgresql.PostgreSqlDAOFactory;
import co.edu.uco.publiuco.data.dao.factory.relational.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory{
	
	public static DAOFactory getFactory(final Factory factory) {
		DAOFactory daoFactory;
		
		switch (factory) {
		case SQLSERVER: {
			daoFactory = new SqlServerDAOFactory();
			break;
		}
		case POSTGRESQL: {
			daoFactory = new PostgreSqlDAOFactory();
			break;
		}
		default:
			throw new IllegalArgumentException("Not implemented yet!");
		}
		return daoFactory;
	}
	
	protected abstract void abrirConexion(); 
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();

	public abstract EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO();
	
	public abstract TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO();
}
