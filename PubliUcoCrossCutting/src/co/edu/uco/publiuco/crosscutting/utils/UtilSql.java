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
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
		}
		try {
			return !connection.isClosed();
		} catch (final SQLException exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION;
			
			throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}catch (final Exception exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION;
			
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
		}catch (final SQLException exception) {
			var userMessage =  UtilSqlMessages.CONNECTION_IS_CLOSE_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_CLOSE_TECHNICAL_SQL_EXCEPTION;
			
		throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}catch (final Exception exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_CLOSE_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_CLOSE_TECHNICAL_EXCEPTION;
			
			throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}
	}
	public static final void initCommitIsReady(final Connection connection) {
		
		try {
			connectionIsOpen(connection);
			if(connection.getAutoCommit()) {
				var userMessage = UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE;
				var technicalMessage = UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_AUTOCOMMIT;
				throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
			}
		}catch (PubliUcoCrossCuttingException exception) {
			throw exception;
		}catch (SQLException exception) {
			var userMessage = UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_SQL_EXCEPTION;
			
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		}catch (final Exception exception) {
			var userMessage = UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_EXCEPTION;
			
			throw PubliUcoCrossCuttingException.create(userMessage, technicalMessage, exception);
		}
	}
}
