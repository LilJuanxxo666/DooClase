package co.edu.uco.publiuco.crosscutting.utils;

public final class Messages {
	
	public static final class UtilSqlMessages{
		public static final String CONNECTION_IS_OPEN_USER_MESSAGE = "Se ha presentado un problema tratando de validar si una conexion estaba o no activa";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION = "Se ha presentado una exception de tipo SqlException, tratando de validar "
				+ "si la conexion estaba o no abierta. Porfavor valide la traza de errores completa de la exception presentada...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION = "Se ha presentado una exception de tipo SqlException, tratando de validar "
				+ "si la conexion estaba o no abierta. Porfavor valide la traza de errores completa de la exception presentada...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION= "Se ha presentado una exception inesperada de tipo Exception, tratando de validar "
				+ "si la conexion estaba o no abierta. Porfavor valide la traza de errores completa de la exception presentada..."; 
	}
}
