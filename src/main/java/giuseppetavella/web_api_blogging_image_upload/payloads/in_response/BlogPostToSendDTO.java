package giuseppetavella.web_api_blogging_image_upload.payloads.in_response;

import java.util.UUID;

public record BlogPostToSendDTO(UUID authorId, 
                                String titolo, 
                                String categoria,
                                String contenuto, int 
                                tempoDiLettura) {


}
