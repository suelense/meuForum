package br.com.alura.forum.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AnswerData(@NotBlank String message,
                         @NotNull LocalDateTime creation_date) {
}
