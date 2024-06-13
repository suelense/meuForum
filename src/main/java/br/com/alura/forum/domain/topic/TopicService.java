package br.com.alura.forum.domain.topic;

import br.com.alura.forum.domain.course.CourseRepository;
import br.com.alura.forum.domain.user.UserRepository;
import br.com.alura.forum.domain.topic.validations.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private List<TopicValidator> validations;

    public TopicDTO topicSave(TopicData data) {
        validations.forEach(v -> v.validate(data));
        var user = userRepository.getReferenceById(data.user_id());
        var course = courseRepository.getReferenceById(data.course_id());
        var topic = new Topic(data, course, user);
        topicRepository.save(topic);
        return new TopicDTO(topic);
    }
}
