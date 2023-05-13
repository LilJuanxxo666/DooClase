package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;

public class DescripcionValidation implements Validation<String>{

	
	private DescripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}
	
	@Override
	public Result execute(String data) {
		var result = Result.create();

		if(true) { //Validar longitud de la cadena min:0 max:250
			result.addMessage("La descripcion del estado tipo relacion insitucion no debe ser mayor de 30...");
		}
		
		return result;
	}

}
