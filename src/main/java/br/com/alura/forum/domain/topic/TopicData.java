package br.com.alura.forum.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicData(@NotBlank String title,
                        @NotBlank String message,
                        @NotNull LocalDateTime creation_date,
                        @NotNull Long course_id,
                        @NotNull Long user_id) {
}
