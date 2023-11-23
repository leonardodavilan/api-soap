package pe.com.prima.apisoap.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.com.prima.apisoap.exception.CustomReniecException;
import pe.com.prima.apisoap.exception.ReniecColaException;


@ControllerAdvice
public class CiamBiometricValidationControllerAdvice {
	

	@ExceptionHandler(ReniecColaException.class)
    public ResponseEntity<CustomReniecException> ciamBiometricValidationException(CustomReniecException e){

		CustomReniecException response = new CustomReniecException();
    	response.setMessage(e.getMessage());
    	   	
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	
	}

}
