package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.exception.GlobalNotFoundException;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.util.TreatmentConstants;


@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler({
		ResponseStatusException.class,
		GlobalNotFoundException.class,
		Exception.class
	})
	public ResponseEntity<GeneralResponse> handleCustomException(Exception ex, WebRequest request) {
		GeneralResponse response = null;
		if(ex instanceof GlobalNotFoundException) {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder()
		        		.code(TreatmentConstants.CODE_ERROR)
		        		.messageError(ex.getMessage())
		        		.build())
					.build();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}else if(ex instanceof ResponseStatusException){
			response = GeneralResponse.builder()
					.response(MessageResponse.builder()
		        		.code(TreatmentConstants.CODE_ERROR)
		        		.messageError(ex.getMessage())
		        		.build())
					.build();
			return new ResponseEntity<>(response, ((ResponseStatusException)ex).getStatus());
		}else {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder()
		        		.code(TreatmentConstants.CODE_ERROR_NO_CONTROLADO)
//		        		.messageError(CustomerConstants.MSG_ERROR_NO_CONTROLADO + ex.getMessage())
		        		.messageError(ex.getMessage())
		        		.build())
					.build();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        GeneralResponse response = GeneralResponse.builder().response(MessageResponse.builder()
        		.code(TreatmentConstants.CODE_ERROR)
        		.messageError(errors.stream()
        		.collect(Collectors.joining(","))).build())
        .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
