package dev.lennyadams.contentcalendar.controller;

import dev.lennyadams.contentcalendar.model.Content;
import dev.lennyadams.contentcalendar.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // Tells Spring: create instance and add to Application Context.
@RequestMapping("/api/content") // Tells Spring: route calls to this URI to this Controller.
@CrossOrigin("http://localhost:5173/") // Only allow `my-vanilla-js-frontend` to fetch from this server.
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

    // CREATE
    /**
     * Adds a valid piece of content to the system.
     * @param content a piece of content that is received from the request body and then validated
     */
    @ResponseStatus(HttpStatus.CREATED) // Returns `201 Created` upon successful creation.
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
    // @RequestBody tells Spring that the content will be sent as a request body.
        repository.save(content);
    }

    // READ
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

    // UPDATE
    /**
     * Updates the piece of content (if it exists) that matches the `id`.
     * @param content the piece of content to be updated
     * @param id the `id` of the piece of content to be updated
     */
    @ResponseStatus(HttpStatus.NO_CONTENT) // Returns `204 No Content` upon successful update.
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }

    // DELETE
    /**
     * Removes content from the system that matches the given ID.
     * @param id the identifier of the content to be removed from the system
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}
