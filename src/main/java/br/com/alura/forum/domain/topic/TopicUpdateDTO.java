package br.com.alura.forum.domain.topic;

import br.com.alura.forum.domain.course.Category;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicUpdateDTO(@NotNull Long id,
                             String title,
                             String message,
                             Boolean status){
}
