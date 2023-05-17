package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
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

		var sqlStatement = "Insert into EstadoTipoRelacionInstitucion(identificador, nombre, descripcion) values (?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setString(3, entity.getDescripcion());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de registrar la informacion estado tipo relacion institucion institucion";
			var technicalMessage = "Se ha presentado un problema tipo SQLException, dentro del metodo create de la clase EstadoTipoRelacionInstitucionSqlServerDAO. Por favor verifique la traza completa del error...";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de registrar la informacion estado tipo relacion institucion institucion";
			var technicalMessage = "Se ha presentado un problema inesperado dentro del metodo create de la clase EstadoTipoRelacionInstitucionSqlServerDAO. Por favor verifique la traza completa del error...";
			
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
		
		try (var preaparedStatement = getConnection().prepareStatement(sqlStatement.toString())){
			
		}catch(SQLException exception){
			
		}catch(Exception exception) {
			
		}
		
		return null;
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
			var userMessage = "Se ha presentado un problema tratando de ajustar la informacion estado tipo relacion institucion institucion";
			var technicalMessage = "Se ha presentado un problema tipo SQLException, dentro del metodo update de la clase EstadoTipoRelacionInstitucionSqlServerDAO. Por favor verifique la traza completa del error...";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de ajustar la informacion estado tipo relacion institucion institucion";
			var technicalMessage = "Se ha presentado un problema inesperado dentro del metodo update de la clase EstadoTipoRelacionInstitucionSqlServerDAO. Por favor verifique la traza completa del error...";
			
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
			var userMessage = "Se ha presentado un problema tratando de dar de baja la informacion estado tipo relacion institucion institucion";
			var technicalMessage = "Se ha presentado un problema tipo SQLException, dentro del metodo delete de la clase EstadoTipoRelacionInstitucionSqlServerDAO. Por favor verifique la traza completa del error...";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de dar de baja la informacion estado tipo relacion institucion institucion";
			var technicalMessage = "Se ha presentado un problema inesperado dentro del metodo delete de la clase EstadoTipoRelacionInstitucionSqlServerDAO. Por favor verifique la traza completa del error...";
			
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
		
		if(UtilObject.isNull(entity)) {
			
			if(!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
			if(!UtilText.getUtilText().isEmpty(entity.getNombre())){
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND").append("nombre=? ");
				setWhere = false;
			}
			if(!UtilText.getUtilText().isEmpty(entity.getDescripcion())){
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


}
