package br.com.alura.forum.domain.topic.validations;

import br.com.alura.forum.domain.ValidationsException;
import br.com.alura.forum.domain.course.CourseRepository;
import br.com.alura.forum.domain.topic.TopicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseExists implements ValidatorTopicService{
    @Autowired
    private CourseRepository courseRepository;

    public void validate(TopicData data) {
        if (!courseRepository.existsById(data.course_id())) {
            throw new ValidationsException("Id do curso não existe");
        }
    }
}
