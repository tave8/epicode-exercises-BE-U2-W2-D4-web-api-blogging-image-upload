package giuseppetavella.web_api_blogging_image_upload.payloads.in_request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewAuthorSentDTO(
        @NotBlank
        @Size(min = 2, max = 30, message = "Il nome dell'autore deve avere tra 2 e 30 caratteri.")
        String nome, 
        String cognome, 
        String email, 
        LocalDate dataNascita) 
{

}
