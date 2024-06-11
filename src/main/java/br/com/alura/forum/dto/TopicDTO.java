package br.com.alura.forum.dto;

import br.com.alura.forum.domain.course.Course;
import br.com.alura.forum.domain.course.CourseData;
import br.com.alura.forum.domain.topic.Topic;
import br.com.alura.forum.domain.user.User;

import java.time.LocalDateTime;

public record TopicDTO(Long id,
                       String title,
                       String message,
                       LocalDateTime creation_date,
                       Boolean status,
                       String course,
                       String user) {
    public TopicDTO(Topic topic) {
        this(topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getCourse().getName(),
                topic.getUser().getEmail());
    }
}
