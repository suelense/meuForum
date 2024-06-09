package br.com.alura.forum.domain.course;

import br.com.alura.forum.dto.CourseUpdateDTO;
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

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public void updateCourse(CourseUpdateDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
    }

    public Boolean getActive() {
        return active;
    }

    public void delete() {
        this.active = false;
    }
}