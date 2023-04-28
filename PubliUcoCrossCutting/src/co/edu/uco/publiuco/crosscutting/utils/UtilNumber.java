package co.edu.uco.publiuco.crosscutting.utils;

public class UtilNumber{
	
	private static final UtilNumber INSTANCE = new UtilNumber();
	public static final byte ZERO = 0;
	
	private UtilNumber(){
		super();
	}
	public static final UtilNumber getUtilNumber() {
		return INSTANCE;
	}
	
	public final boolean isNull(final byte numero) {
		return UtilObject.isNull(numero);
	}
	
	public final <T extends Number> Number getDefault(final byte number, final byte defaultValue) {	
		byte result = number;
		
		if(isNull(number)) {
			result = isNull(defaultValue) ? ZERO : defaultValue;
		}
		return result;
	}
	
	public final <T extends Number> Number getDefault(final byte number) {
		return getDefault(number, ZERO).byteValue();
	}
}
