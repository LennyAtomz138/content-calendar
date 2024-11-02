package dev.lennyadams.contentcalendar.controller;

import dev.lennyadams.contentcalendar.model.Content;
import dev.lennyadams.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Tells Spring: create instance and add to Application Context.
@RequestMapping("/api/content") // Tells Spring: route calls to this URI to this Controller.
public class ContentController {

    private final ContentCollectionRepository repository;

    /**
     * Constructs an autowired instance of the Content Collection Repository.
     * @param repository content collection repository
     */
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all the pieces of content within the system.
     * Leverages `findAll()` from autowired repository.
     * This GET request is automatically invoked when "/api/content" is called,
     * and this behavior is indicated by the empty route path in its GET mapping.
     * @return all pieces of content within the system
     */
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    // TODO: Make CRUD endpoints: Create, Read, Update, Delete

}
