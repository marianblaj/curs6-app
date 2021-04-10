package ro.fastrackit.curs6.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    ApiError handleResourceNotFoundException(ResourceNotFoundException rnfe){
        return new ApiError(1001, rnfe.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleOtherException(Exception ex) {
        return new ApiError(0000, "Generic error " + ex.getMessage());
    }
}

@Value
class ApiError{
    int code;
    String message;
}