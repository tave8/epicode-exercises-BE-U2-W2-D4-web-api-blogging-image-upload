package giuseppetavella.web_api_blogging_image_upload.controllers;


import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import giuseppetavella.web_api_blogging_image_upload.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging_image_upload.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    
    @Autowired
    private AuthorsService authorsService;
    
    
    @GetMapping
    public List<Author> findAll() {
        return this.authorsService.findAll(); 
    }
    
    @GetMapping("/{authorId}")
    public Author findById(@PathVariable UUID authorId) {
        return this.authorsService.findById(authorId);
    }

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Author add(@RequestBody NewAuthorPayload body) {
        return this.authorsService.addNewAuthor(body);
    }
    
    //
    // @PutMapping("/{authorId}")
    // public Author update(@PathVariable String authorId, @RequestBody NewAuthorPayload body) {
    //     return authorsService.update(authorId, body);
    // }
    //
    //
    // @DeleteMapping("/{authorId}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void delete(@PathVariable String authorId) {
    //     authorsService.delete(authorId);
    // }
    
}
