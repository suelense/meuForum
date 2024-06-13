package br.com.alura.forum.controller;

import br.com.alura.forum.domain.course.Course;
import br.com.alura.forum.domain.course.CourseData;
import br.com.alura.forum.domain.course.CourseRepository;
import br.com.alura.forum.domain.course.CourseUpdateDTO;
import br.com.alura.forum.domain.course.CourseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerCourse(@RequestBody @Valid CourseData data,
                                         UriComponentsBuilder uriComponentsBuilder) {
        var course = new Course(data);
        repository.save(course);
        var uri = uriComponentsBuilder.path("/courses/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(new CourseDTO(course));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> courseList(@PageableDefault Pageable pageable) {
        var list = repository.findAllByActiveTrue(pageable).stream().map(CourseDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCourse(@RequestBody @Valid CourseUpdateDTO data) {
        var course = repository.getReferenceById(data.id());
        course.updateCourse(data);
        return ResponseEntity.ok(new CourseDTO(course));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        var course = repository.getReferenceById(id);
        course.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity showCourse(@PathVariable Long id) {
        var course = repository.getReferenceById(id);
        return ResponseEntity.ok(new CourseDTO(course));
    }
}
