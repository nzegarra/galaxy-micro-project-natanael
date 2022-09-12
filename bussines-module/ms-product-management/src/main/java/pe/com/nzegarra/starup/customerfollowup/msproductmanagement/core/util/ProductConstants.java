package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.util;

public class ProductConstants {

	private ProductConstants() {};
	
	public static final String API_PRODUCT = "/v1/product";
	public static final String API_PRODUCT_CATEGORY = "/v1/product-category";
	public static final String API_PRESENTATION = "/v1/presentation";
	public static final Integer CODE_SUCCES = 0;
	public static final String MSG_SUCCES = "Exito";
	public static final Integer CODE_ERROR = 1;
	public static final String MSG_ERROR = "Ocurrió un error en su solicitud";
	public static final Integer CODE_ERROR_NO_CONTROLADO = -1;
	public static final String MSG_ERROR_NO_CONTROLADO = "Ocurrió un error no controlado";
}
