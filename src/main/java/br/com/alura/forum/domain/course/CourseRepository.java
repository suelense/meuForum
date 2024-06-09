package br.com.alura.forum.domain.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);

    Page<Course> findAllByActiveTrue(Pageable pageable);
}
