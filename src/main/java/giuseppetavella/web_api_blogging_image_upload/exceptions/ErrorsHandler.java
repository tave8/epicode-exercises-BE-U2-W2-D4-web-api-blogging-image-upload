package giuseppetavella.web_api_blogging_image_upload.exceptions;

import giuseppetavella.web_api_blogging_image_upload.payloads.in_response.ErrorsToSendDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsToSendDTO handleNotFoundException(NotFoundException ex) {
        return new ErrorsToSendDTO(ex.getMessage());
    }
    
    
    @ExceptionHandler(PayloadValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsToSendDTO handlePayloadValidationError(PayloadValidationException ex) {
        return new ErrorsToSendDTO(ex.getMessage(), ex.getErrors());
    }
    
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsToSendDTO handleGenericException(Exception ex) {
        ex.printStackTrace();
        return new ErrorsToSendDTO("C'è stato un error nei server. Stiamo risolvendo.");
    }
    
}
