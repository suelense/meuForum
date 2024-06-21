package br.com.alura.forum.domain.topic;

import br.com.alura.forum.domain.course.Course;
import br.com.alura.forum.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Topic(TopicData data, Course course, User user) {
        this.title = data.title();
        this.message = data.message();
        this.creationDate = data.creation_date();
        this.status = true;
        this.course = course;
        this.user = user;
    }

    public void delete() {
        this.status = false;
    }

    public void updateCourse(TopicUpdateDTO data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.message() != null) {
            this.message = data.message();
        }
        if (data.status() != null) {
            this.status = data.status();
        }
    }
}
