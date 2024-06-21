package br.com.alura.forum.domain.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    public Course(CourseData data) {
        this.name = data.name();
        this.category = data.category();
        this.active = true;
    }

    public void updateCourse(CourseUpdateDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
    }

    public void delete() {
        this.active = false;
    }
}
