package br.com.alura.forum.domain.course;

public record CourseDTO(Long id,
                        Category category,
                        String name,
                        Boolean active) {
    public CourseDTO(Course course) {
        this(course.getId() ,course.getCategory(), course.getName(), course.getActive());
    }
}
