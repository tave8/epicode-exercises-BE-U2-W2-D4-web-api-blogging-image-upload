package giuseppetavella.web_api_blogging_image_upload.controllers;


import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import giuseppetavella.web_api_blogging_image_upload.entities.BlogPost;
import giuseppetavella.web_api_blogging_image_upload.payloads.BlogPostToSendPayload;
import giuseppetavella.web_api_blogging_image_upload.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging_image_upload.payloads.NewBlogPostPayload;
import giuseppetavella.web_api_blogging_image_upload.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    public Page<BlogPostToSendPayload> findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  // FIX: il default value deve essere l'attributo dell'oggetto.
                                  // prima avevo scritto created_at e mi dice che "non trovava
                                  // la proprietà created sull'entità BlogPost". era un messaggio di errore non corretto,
                                  // perché sembra si fosse dimenticato la parte dopo l'underscore (_at)
                                  @RequestParam(defaultValue = "createdAt") String sortBy) {
        return this.blogPostsService.findAllAsPayload(page, size, sortBy);
    }

    @GetMapping("/{blogPostId}")
    public BlogPostToSendPayload findById(@PathVariable UUID blogPostId) {
        return this.blogPostsService.findByIdAsPayload(blogPostId);
    }
    
    // fare un payload custom per blog post e ritornare quello

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BlogPost add(@RequestBody NewBlogPostPayload body) {
        return this.blogPostsService.saveNewBlogPost(body);
    }
    //
    // @PutMapping("/{blogPostId}")
    // public BlogPost update(@PathVariable String blogPostId, @RequestBody NewBlogPostPayload body) {
    //     return blogPostsService.update(blogPostId, body);
    // }
    //
    //
    // @DeleteMapping("/{blogPostId}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void delete(@PathVariable String blogPostId) {
    //     blogPostsService.delete(blogPostId);
    // }

}
