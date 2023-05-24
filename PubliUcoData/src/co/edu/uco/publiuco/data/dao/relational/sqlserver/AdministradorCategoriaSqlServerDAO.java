package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionSqlServerDAOMessages;
import co.edu.uco.publiuco.data.dao.AdministradorCategoriaDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class AdministradorCategoriaSqlServerDAO extends SqlDAO<AdministradorCategoriaEntity>
		implements AdministradorCategoriaDAO {

	public AdministradorCategoriaSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final AdministradorCategoriaEntity entity) {

		var sqlStatement = "INSERT INTO administrador_categoria(identificador, tipo_identificacion, numero_identificacion, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, indicador_pais, telefono, relacion_institucion, correo_confirmado, telefono_confirmado, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getTipoIdentificacion().getIdentificador());
			preparedStatement.setInt(3, entity.getNumeroIdentificacion());
			preparedStatement.setString(4, entity.getPrimerNombre());
			preparedStatement.setString(5, entity.getSegundoNombre());
			preparedStatement.setString(6, entity.getPrimerApellido());
			preparedStatement.setString(7, entity.getSegundoApellido());
			preparedStatement.setString(8, entity.getCorreo());
			preparedStatement.setString(9, entity.getIndicadorPaisTelefono());
			preparedStatement.setInt(10, entity.getTelefono());
			preparedStatement.setObject(11, entity.getTipoRelacion().getIdentificador());
			preparedStatement.setObject(12, entity.getCorreoConfirmado().getIdentificador());
			preparedStatement.setObject(13, entity.getTelefonoConfirmado().getIdentificador());
			preparedStatement.setObject(14, entity.getEstado().getIdentificador());

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
	public final List<AdministradorCategoriaEntity> read(final AdministradorCategoriaEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();

		sqlStatement.append(prepareSelect());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareOrderBy());

		try (var preaparedStatement = getConnection().prepareStatement(sqlStatement.toString())) {
			

		} catch (final SQLException exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_SQLEXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionSqlServerDAOMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}
		return null;
	}

	@Override
	public final void update(final AdministradorCategoriaEntity entity) {
		var sqlStatement = "UPDATE administrador_categoria SET nombre=?, tipo_identificacion=?, numero_identificacion=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, correo=?, indicador_pais=?, telefono=?, relacion_institucion=?, correo_confirmado=?, telefeno_confirmado=?, estado=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getTipoIdentificacion().getIdentificador());
			preparedStatement.setInt(2, entity.getNumeroIdentificacion());
			preparedStatement.setString(3, entity.getPrimerNombre());
			preparedStatement.setString(4, entity.getSegundoNombre());
			preparedStatement.setString(5, entity.getPrimerApellido());
			preparedStatement.setString(6, entity.getSegundoApellido());
			preparedStatement.setString(7, entity.getCorreo());
			preparedStatement.setString(8, entity.getIndicadorPaisTelefono());
			preparedStatement.setInt(9, entity.getTelefono());
			preparedStatement.setObject(10, entity.getTipoRelacion().getIdentificador());
			preparedStatement.setObject(11, entity.getCorreoConfirmado().getIdentificador());
			preparedStatement.setObject(12, entity.getTelefonoConfirmado().getIdentificador());
			preparedStatement.setObject(13, entity.getEstado().getIdentificador());
			preparedStatement.setObject(14, entity.getIdentificador());

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
	public final void delete(final AdministradorCategoriaEntity entity) {
		var sqlStatement = "DELETE FROM administrador_categoria WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

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
	protected final String prepareWhere(final AdministradorCategoriaEntity entity, List<Object> parameters) {
		/*
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (UtilObject.isNull(entity)) {

			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
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
		*/
		return null;
	}

	@Override
	protected final String prepareOrderBy() {
		return "ORDER BY nombre ASC";
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<AdministradorCategoriaEntity> executeQuery(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

}
