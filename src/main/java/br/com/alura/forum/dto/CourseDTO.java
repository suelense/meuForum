package br.com.alura.forum.dto;

import br.com.alura.forum.domain.course.Category;
import br.com.alura.forum.domain.course.Course;

public record CourseDTO(Long id,
                        Category category,
                        String name,
                        Boolean active) {
    public CourseDTO(Course course) {
        this(course.getId() ,course.getCategory(), course.getName(), course.getActive());
    }
}
