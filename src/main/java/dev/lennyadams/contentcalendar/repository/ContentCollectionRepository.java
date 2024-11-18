package dev.lennyadams.contentcalendar.repository;

import dev.lennyadams.contentcalendar.model.Content;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Keeps a collection of pieces of content in-memory instead of within database.
 */
@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    /**
     * Parses content list to find and ID that matches the value of `id` parameter.
     * Once it finds it--if it even exists--then it returns the first true instance.
     * @param id an identifier of a specific piece of content
     * @return first true instance in the collection that matches the value of `id` parameter
     */
    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    /**
     * Saves a piece of content to the system.
     * @param content a piece of content to be saved to the system
     */
    public void save(Content content) {
        // If the content already exists, remove it before adding updated content to the system.
        contentList.removeIf(c -> c.id().equals(content.id()));
        // Otherwise, simply add the content to the system.
        contentList.add(content);
    }

    /**
     * Checks if a piece of content exists under a given ID.
     * @param id a piece of content to be checked within the system
     * @return true if there exists a piece of content in the system that matches the given ID
     */
    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    /**
     * Removes content from the system that matches the ID.
     * @param id the identifier of the content to be removed
     */
    public void delete(Integer id) {
        // If there is content that matches the ID, remove it from the system.
        contentList.removeIf(c -> c.id().equals(id));
    }
}
