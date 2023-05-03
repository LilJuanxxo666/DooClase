package co.edu.uco.publiuco.crosscutting.utils;

public final class UtilInteger{
	
	private static final UtilInteger INSTANCE = new UtilInteger();
	public static final Integer EMPTY = 0; 
	
	private UtilInteger(){
		super();
	}
	public static final UtilInteger getUtilInteger() {
		return INSTANCE;
	}
	
	public final boolean isNull(final Integer numero) {
		return UtilObject.isNull(numero);
	}
	public final Integer getDefaultInteger(final Integer numero, final Integer defaultValue) {
			Integer result = numero;
			if(isNull(numero)) {
				result = isNull(defaultValue) ? EMPTY : defaultValue;
			}
			return result;
	}
	public final Integer getDefaultValue() {
		return EMPTY;
	}
	public final Integer getDefaultInteger(final Integer numero) {
		return getDefaultInteger(numero, EMPTY);
	}
}
