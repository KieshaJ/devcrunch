package tech.kjworks.dcpostservice.util.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tech.kjworks.dcpostservice.util.enums.ContentType;

public record ContentBlockDTO(
        @NotNull(message = "Order required")
        Integer order,
        @NotNull(message = "Content type required")
        ContentType contentType,
        @Size(min = 10,
                max = 4096,
                message = "Content should be between 10 and 4096 characters long")
        String content,
        List<String> commentIds) {

}
