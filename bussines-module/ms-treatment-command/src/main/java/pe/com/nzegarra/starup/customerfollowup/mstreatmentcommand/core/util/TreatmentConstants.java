package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.util;

public class TreatmentConstants {

	private TreatmentConstants() {};
	
	public static final String API_TREATMENT = "/v1/treatment";
	public static final Integer CODE_SUCCES = 0;
	public static final String MSG_SUCCES = "Exito";
	public static final Integer CODE_ERROR = 1;
	public static final String MSG_ERROR = "Ocurrió un error en su solicitud";
	public static final Integer CODE_ERROR_NO_CONTROLADO = -1;
	public static final String MSG_ERROR_NO_CONTROLADO = "Ocurrió un error no controlado";
}
