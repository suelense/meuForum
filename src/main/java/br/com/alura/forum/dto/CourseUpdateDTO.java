package br.com.alura.forum.dto;

import br.com.alura.forum.domain.course.Category;
import jakarta.validation.constraints.NotNull;

public record CourseUpdateDTO(@NotNull Long id,
                              String name,
                              Category category) {
}
