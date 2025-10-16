package MyApp.config;


import MyApp.dtos.ErrorDto;
import MyApp.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1️⃣ What @ControllerAdvice is?
 *
 * @ControllerAdvice is a Spring annotation that allows you to handle exceptions globally for all controllers in your application.
 *
 * Instead of writing try/catch in every controller, you can centralize exception handling.
 *
 * It can also be used to add global data to all responses or handle cross-cutting concerns.
 *
 * 2️⃣ How it works ?
 *
 * When a controller throws an exception, Spring looks for a method annotated with @ExceptionHandler inside a @ControllerAdvice class.
 *
 * That method decides what HTTP response to return, including status code and body.**/

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex){
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDto(ex.getMessage()));

    }
}
