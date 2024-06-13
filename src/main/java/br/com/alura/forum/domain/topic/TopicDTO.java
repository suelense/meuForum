package br.com.alura.forum.domain.topic;

import java.time.LocalDateTime;

public record TopicDTO(Long id,
                       String title,
                       String message,
                       LocalDateTime creation_date,
                       Boolean status,
                       String course,
                       Long userId,
                       String userName) {

    public TopicDTO(Topic topic) {
        this(topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getCourse().getName(),
                topic.getUser().getId(),
                topic.getUser().getName());
    }
}
