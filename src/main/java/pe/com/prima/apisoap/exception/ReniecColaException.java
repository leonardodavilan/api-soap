package pe.com.prima.apisoap.exception;


import org.springframework.http.HttpStatus;

public class ReniecColaException extends RuntimeException{

    private static final long serialVersionUID = 9085551L;

    private HttpStatus httpStatus;

    public ReniecColaException() {
    }

    public ReniecColaException(String message) {
        super(message);
    }

    public ReniecColaException(Throwable cause) {
        super(cause);
    }

    public ReniecColaException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public ReniecColaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReniecColaException(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

}
