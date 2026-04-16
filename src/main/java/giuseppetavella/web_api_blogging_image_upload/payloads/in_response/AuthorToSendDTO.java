package giuseppetavella.web_api_blogging_image_upload.payloads.in_response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record AuthorToSendDTO(
        UUID authorId,
        
        String nome,

        String cognome,

        String email,

        LocalDate dataNascita) 
{
}
