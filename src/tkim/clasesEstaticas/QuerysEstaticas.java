package tkim.clasesEstaticas;

public class QuerysEstaticas {

	static final String INSERT = 
    		"INSERT INTO poo_uoc.ARTICULOS (codigo_articulo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) "
    		+ "values (?, ?, ?, ?, ?)";
    static final String SELECTALL = 
    		"SELECT * FROM ARTICULOS ORDER BY CODIGO_ARTICULO ASC";
    static final String SELECEXISTE = 
    		"SELECT codigo_articulo FROM ARTICULOS WHERE CODIGO_ARTICULO = ? ORDER BY CODIGO_ARTICULO ASC";
    static final String SELECTCLIENTESTODOS = 
    		"SELECT * FROM CLIENTES";
    static final String SELECPEDIDOSPENDIENTES = 
    		"SELECT * FROM ARTICULOS WHERE CODIGO_ARTICULO = ? ORDER BY CODIGO_ARTICULO ASC";
    static final String INSERTCLIENTE = 
    		"INSERT INTO poo_uoc.CLIENTES (nif, nombre, domicilio, email, tipo_cliente, cuota_anual, descuento_envio)" 
    + "value (?,?, ?, ?, ?, ?, ?)";
    
    static final String SELECTEXISTECLIENTE =
    		"SELECT * FROM poo_uoc.CLIENTES WHERE NIF = ?";
    
    static final String SELECTTIPOCLIENTE = 
    		"SELECT * FROM poo_uoc.CLIENTES WHERE tipo_cliente = ?";
    static final String DELETEPEDIDO = 
    		"DELETE FROM poo_uoc.PEDIDOS WHERE numero_pedido = ?";
    static final String SELECTPEDIDO =  //    pedidoExiste
    		"select tiempo_preparacion, fecha_hora_pedido  from poo_uoc.pedidos inner join poo_uoc.articulos on articulo_fk = codigo_articulo where numero_pedido = ?";
    static final String SELECPEXISTE =  //    pedidoExiste
    		"SELECT numero_pedido FROM PEDIDOS WHERE NUMERO_PEDIDO = ? ORDER BY NUMERO_PEDIDO ASC";
    static final String INSERTPEDIDO = 	// addPedido
    		"INSERT INTO poo_uoc.PEDIDOS (numero_pedido, unidades_pedido, fecha_hora_pedido, total_pedido, cliente_fk, articulo_fk)"
    		+ "values (?, ?, ?, ?, ?, ?)";
    static final String SELECTARTICULO =  //    pedidoExiste
    		"select * from ARTICULOS WHERE CODIGO_ARTICULO  = ?";
    static final String SELECTPEDIDOPORCLIENTE =  
            "select numero_pedido, unidades_pedido, fecha_hora_pedido, total_pedido, nif, nombre, domicilio, email, tipo_cliente, codigo_articulo, descripcion, precio_venta, gastos_envio, tiempo_preparacion from poo_uoc.pedidos, poo_uoc.clientes, poo_uoc.articulos where articulo_fk = codigo_articulo and cliente_fk = nif and cliente_fk = ?";
	
    public static String getInsert() {
		return INSERT;
	}
	public static String getSelectall() {
		return SELECTALL;
	}
	public static String getSelecexiste() {
		return SELECEXISTE;
	}
	public static String getSelectclientestodos() {
		return SELECTCLIENTESTODOS;
	}
	public static String getSelecpedidospendientes() {
		return SELECPEDIDOSPENDIENTES;
	}
	public static String getInsertcliente() {
		return INSERTCLIENTE;
	}
	public static String getSelectexistecliente() {
		return SELECTEXISTECLIENTE;
	}
	public static String getSelecttipocliente() {
		return SELECTTIPOCLIENTE;
	}
	public static String getDeletepedido() {
		return DELETEPEDIDO;
	}
	public static String getSelectpedido() {
		return SELECTPEDIDO;
	}
	public static String getSelecpexiste() {
		return SELECPEXISTE;
	}
	public static String getInsertpedido() {
		return INSERTPEDIDO;
	}
	public static String getSelectarticulo() {
		return SELECTARTICULO;
	}
	public static String getSelectpedidoporcliente() {
		return SELECTPEDIDOPORCLIENTE;
	}
	
    
}
