package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public class IdentificadorValidation implements Validation<UUID> {

	private IdentificadorValidation() {
		super();
	}
	
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().execute(data);
	}
	@Override
	public Result execute(UUID data) {
		var result = Result.create();

		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el identificador del estado tipo relacion institucion vacio");
		}else if(UtilUUID.isDefault(data)) {
			result.addMessage("No es posible tener el identificador de Estado tipo relacion isntitucion...");
		}
		
		return result;
	}

}
