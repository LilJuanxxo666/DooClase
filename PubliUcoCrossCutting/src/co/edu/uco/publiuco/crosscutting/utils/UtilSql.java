package co.edu.uco.publiuco.crosscutting.utils;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoCrossCuttingException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.UtilSqlMessages;

public final class UtilSql {

	private UtilSql() {
		super();
	}

	public static boolean connectionIsOpen(final Connection connection) {
		if (UtilObject.isNull(connection)) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = "";
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
		}
		try {
			return !connection.isClosed();
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de validar si una conexion estaba o no activa";
			var technicalMessage = "";
			
			throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema tratando de validar si una conexion estaba o no activa";
			var technicalMessage = "Se ha presentado una exception inesperada de tipo Exception, tratando de validar "
					+ "si la conexion estaba o no abierta. Porfavor valide la traza de errores completa de la exception presentada...";
			
			throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}
	}
	public static final void closeConnection(final Connection connection) {
		try {
			if(!connectionIsOpen(connection)) {
				connection.close();
			}
		}catch (PubliUcoCrossCuttingException exception) {
			throw exception;
		}
		catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de validar si una conexion estaba o no activa";
			var technicalMessage = "";
			
		throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema tratando de validar si una conexion estaba o no activa";
			var technicalMessage = "Se ha presentado una exception inesperada de tipo Exception, tratando de validar "
					+ "si la conexion estaba o no abierta. Porfavor valide la traza de errores completa de la exception presentada...";
			
			throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}
	}
}
