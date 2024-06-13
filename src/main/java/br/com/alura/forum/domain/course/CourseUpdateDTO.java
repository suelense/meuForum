package br.com.alura.forum.domain.course;

import jakarta.validation.constraints.NotNull;

public record CourseUpdateDTO(@NotNull Long id,
                              String name,
                              Category category) {
}
