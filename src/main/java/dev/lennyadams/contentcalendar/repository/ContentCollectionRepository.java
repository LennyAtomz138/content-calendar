package dev.lennyadams.contentcalendar.repository;

import dev.lennyadams.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Keeps a collection of pieces of content in-memory instead of within database.
 */
@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    /**
     * Parses content list to find and ID that matches the value of `id` parameter.
     * Once it finds it--if it even exists--then it returns the first true instance.
     * @param id an identifier of a specific piece of content
     * @return first true instance in the collection that matches the value of `id` parameter
     */
    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

}
