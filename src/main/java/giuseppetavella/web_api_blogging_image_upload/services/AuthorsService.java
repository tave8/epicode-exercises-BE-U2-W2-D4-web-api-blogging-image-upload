package giuseppetavella.web_api_blogging_image_upload.services;


import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import giuseppetavella.web_api_blogging_image_upload.exceptions.NotFoundException;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_request.NewAuthorSentDTO;
import giuseppetavella.web_api_blogging_image_upload.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorsService {
    
    @Autowired
    private AuthorsRepository authorsRepository;
    
    public List<Author> findAll() {
        return this.authorsRepository.findAll();
    }
    
    public Author addNewAuthor(NewAuthorSentDTO body) {
        // fai le verifiche qui prima di aggiungere l'autore
        
        Author newAuthor = new Author(
                body.nome(),
                body.cognome(),
                body.email(),
                body.dataNascita()
        );

        this.authorsRepository.save(newAuthor);
        return newAuthor;
    }
    
    //
    // public Author update(String authorIdStr, NewAuthorPayload body) {
    //     Author author = this.findOne(authorIdStr);
    //    
    //     author.setNome(body.getNome());
    //     author.setCognome(body.getCognome());
    //     author.setEmail(body.getEmail());
    //     author.setDataNascita(body.getDataNascita());
    //    
    //     return author;
    // }
    //
    //
    // public Author delete(String authorIdStr) {
    //     Author author = this.findOne(authorIdStr);
    //
    //     this.authors.remove(author);
    //
    //     return author;
    // }
    //
    //
    //
    
    public Author findById(UUID authorId) throws NotFoundException {
        Optional<Author> maybeAuthor = this.authorsRepository.findById(authorId);
        
        if (maybeAuthor.isEmpty()) {
            throw new NotFoundException(authorId, "autore");
        }
        
        return maybeAuthor.get();
    }
    
}
