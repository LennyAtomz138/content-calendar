package dev.lennyadams.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * A record of content, where some of the content is validated.
 * @param id Identifier of the content
 * @param title Title of the content
 * @param description Content description
 * @param status Status of the content
 * @param contentType Type of the content
 * @param dateCreated Date of content creation
 * @param dateUpdated Date of content update
 * @param url Uniform Resource Locator
 */
public record Content(

        Integer id,

        @NotBlank
        String title,

        @NotBlank
        String description,

        Status status,

        Type contentType,

        LocalDateTime dateCreated,

        LocalDateTime dateUpdated,

        String url) {
}
