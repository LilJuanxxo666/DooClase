package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common.NombreValidation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public final class RegistrarEstadoTipoRelacionInstitucionValidation implements Validation<EstadoTipoRelacionInstitucionDTO>{

	private RegistrarEstadoTipoRelacionInstitucionValidation() {
		super();
	}
	
	public static final Result validate(final EstadoTipoRelacionInstitucionDTO data) {
		return new RegistrarEstadoTipoRelacionInstitucionValidation().execute(data);
	}
	
	@Override
	public final Result execute(final EstadoTipoRelacionInstitucionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo estado tipo relacion institucion con los datos ingresados");
		}else {
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}
		
		return result;
	}
	
	
	
}
