package br.com.alura.forum.domain.topic;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TopicData(@NotBlank String title,
                        @NotBlank String message,
                        @NotBlank LocalDateTime creation_date) {
}
