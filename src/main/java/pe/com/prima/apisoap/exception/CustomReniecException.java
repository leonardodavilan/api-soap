package pe.com.prima.apisoap.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomReniecException implements Serializable {
	
	private static final long serialVersionUID = 5656574515548L;

	private String message;
}

