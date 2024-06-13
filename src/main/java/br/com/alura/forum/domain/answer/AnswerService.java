package br.com.alura.forum.domain.answer;

import br.com.alura.forum.domain.topic.TopicRepository;
import br.com.alura.forum.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public AnswerDTO registerAnswer(AnswerData data) {
        var user = userRepository.getReferenceById(data.user_id());
        var topic = topicRepository.getReferenceById(data.topic_id());
        var answer = new Answer(data, topic, user);
        answerRepository.save(answer);
        return new AnswerDTO(answer);
    }
}
