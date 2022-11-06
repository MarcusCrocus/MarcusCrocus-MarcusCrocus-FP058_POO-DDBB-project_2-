package tkim.clasesEstaticas;

public class QuerysEstaticas {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_USER = "root";
    static final String DB_PASS = "1234";
    static final String DB_URL = "jdbc:mysql://localhost/poo_uoc?user=" + DB_USER + "&password=" + DB_PASS +"&serverTimezone=UTC";
    static final String INSERT = 
    		"INSERT INTO poo_uoc.ARTICULOS (codigo_articulo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) "
    		+ "values (?, ?, ?, ?, ?)";
    static final String SELECTALL = 
    		"SELECT * FROM ARTICULOS ORDER BY CODIGO_ARTICULO ASC";
    static final String SELECEXISTE = 
    		"SELECT codigo_articulo FROM ARTICULOS WHERE CODIGO_ARTICULO = ? ORDER BY CODIGO_ARTICULO ASC";
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}
	public static String getDbUser() {
		return DB_USER;
	}
	public static String getDbPass() {
		return DB_PASS;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	public static String getInsert() {
		return INSERT;
	}
	public static String getSelectall() {
		return SELECTALL;
	}
	public static String getSelecexiste() {
		return SELECEXISTE;
	}
    
    
}
