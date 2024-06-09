package br.com.alura.forum.domain.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseData(@NotBlank String name,
                         @NotNull Category category) {
}
