package br.com.lucasribeironicoleti.calculator.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@ControllerAdvice //é um conselho do controlador, para gerenciar exceções
@RestController //é a Rest Controller
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)//pegar exceções genéricas
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidNumberOperationException.class)//pegar exceção personalizada
    public final ResponseEntity<ExceptionResponse> handleInvalidNumberOperationException(Exception e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
