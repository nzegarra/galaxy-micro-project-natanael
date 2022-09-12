package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.exception;

public class GlobalNotFoundException extends Exception{

	private int code;
	private String message;
	
	public GlobalNotFoundException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
