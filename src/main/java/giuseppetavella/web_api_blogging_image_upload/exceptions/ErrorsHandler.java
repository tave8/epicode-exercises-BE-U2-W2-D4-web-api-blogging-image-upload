package giuseppetavella.web_api_blogging_image_upload.exceptions;

import giuseppetavella.web_api_blogging_image_upload.payloads.ErrorsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFoundException(NotFoundException ex) {
        return new ErrorsPayload(ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGenericException(Exception ex) {
        ex.printStackTrace();
        return new ErrorsPayload("C'è stato un error nei server. Stiamo risolvendo.");
    }
    
}
