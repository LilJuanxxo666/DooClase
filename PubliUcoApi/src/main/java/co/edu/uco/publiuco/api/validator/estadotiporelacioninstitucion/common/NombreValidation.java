package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class NombreValidation implements Validation<String>{

	private NombreValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new NombreValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();

		if(UtilText.getUtilText().isEmpty(data)) {
			result.addMessage("No es posible continuar con el nombre del estado tipo relacion institucion vacio");
		}else {
			if(true) { //Validar longitud de la cadena min:1 max:30
				result.addMessage("El nombre del estado tipo relacion insitucion no debe ser menor de 1 y mayor de 30...");
			}
			if(true) { //Validar solo letras y espacios
				result.addMessage("El nombre del estado tipo relacion insitucion solo puede contener letras");
			}
		}
		
		return result;
	}

}
