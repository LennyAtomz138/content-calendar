package dev.lennyadams.contentcalendar.controller;

import dev.lennyadams.contentcalendar.model.Content;
import dev.lennyadams.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    /**
     * Adds a piece of content to the system.
     * @param content a piece of content to be added to the system
     */
    @PostMapping("")
    public void create(@RequestBody Content content) {
    // @RequestBody tells Spring that the content will be sent as a request body.
        repository.save(content);
    }

    /**
     * Finds a piece of content in the system by ID.
     * @param id identifier of a given piece of content
     * @return content that is mapped to `id`
     */
    @GetMapping("{id}") // Note the usage of dynamic variable -> {id}
    public Content findById(@PathVariable Integer id) {
    // @PathVariable is used to map {id} to `id`.
    // * It maps whatever is in the path to whatever parameter succeeds @PathVariable.
        // Find the content by the ID if it exists...
        return repository.findById(id)
                // ...otherwise throw a 404 error.
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

}
