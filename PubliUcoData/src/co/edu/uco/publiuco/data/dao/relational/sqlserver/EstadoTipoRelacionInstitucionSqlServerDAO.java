package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionSqlServerDAOMessages;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionSqlServerDAO extends SqlDAO<EstadoTipoRelacionInstitucionEntity>
		implements EstadoTipoRelacionInstitucionDAO {

	public EstadoTipoRelacionInstitucionSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final EstadoTipoRelacionInstitucionEntity entity) {

		var sqlStatement = "Insert into estado(identificador, nombre, descripcion, clase_nombre) values (?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setString(3, entity.getDescripcion());
			preparedStatement.setString(3, "EstadoTipoRelacionInstitucion");

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.REGISTER_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.REGISTER_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.REGISTER_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
	}

	@Override
	public final List<EstadoTipoRelacionInstitucionEntity> read(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();

		sqlStatement.append(prepareSelect());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareOrderBy());

		try (var preaparedStatement = getConnection().prepareStatement(sqlStatement.toString())) {

			setParameters(preaparedStatement, parameters);
			
			return executeQuery(preaparedStatement);

		}catch (final PubliUcoDataException exception) { 
			throw exception;
		}
		catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
	}

	@Override
	public final void update(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = "UPDATE EstadoTipoRelacionInstitucion SET nombre=?, descripcion=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setString(1, entity.getNombre());
			preparedStatement.setString(2, entity.getDescripcion());
			preparedStatement.setObject(3, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.UPDATE_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.UPDATE_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.REGISTER_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.UPDATE_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
	}

	@Override
	public final void delete(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = "DELETE FROM EstadoTipoRelacionInstitucion WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setString(1, entity.getNombre());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.DELETE_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.DELETE_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.DELETE_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.DELETE_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
	}

	@Override
	protected final String prepareSelect() {
		return "SELECT identificador, nombre, descripcion ";
	}

	@Override
	protected final String prepareFrom() {
		return "FROM EstadoTipoRelacionInstitucion ";
	}

	@Override
	protected final String prepareWhere(final EstadoTipoRelacionInstitucionEntity entity, List<Object> parameters) {

		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND").append("nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND").append("descripcion LIKE %?% ");
			}
		}
		return where.toString();
	}

	@Override
	protected final String prepareOrderBy() {
		return "ORDER BY nombre ASC";
	}

	@Override
	protected final void setParameters(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			if (!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStatement)) {
				for (int i = 0; i < parameters.size(); i++) {
					preparedStatement.setObject(i + 1, parameters.get(i));
				}
			}
		} catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			// solucionar eso, en el metodo setParameters

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
	}

	@Override
	protected List<EstadoTipoRelacionInstitucionEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<EstadoTipoRelacionInstitucionEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				var entityTmp = new EstadoTipoRelacionInstitucionEntity(
						resultSet.getObject("identificador", UUID.class), resultSet.getString("nombre"),
						resultSet.getString("descripcion"));
				
				result.add(entityTmp);
			}

		} catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			// solucionar eso, en el metodo execute query
			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
		return result;
	}

}
