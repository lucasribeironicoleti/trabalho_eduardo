package br.com.lucasribeironicoleti.calculator.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//define o código de status HTTP
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNumberOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidNumberOperationException(String exception){
        super(exception);
    }
}
