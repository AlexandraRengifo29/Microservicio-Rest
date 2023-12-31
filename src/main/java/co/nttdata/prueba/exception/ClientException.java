package co.nttdata.prueba.exception;

import org.springframework.http.HttpStatus;

public class ClientException extends RuntimeException{
    private final HttpStatus status;
    private final String message;

    public ClientException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
