package br.com.alura.forum.domain.topic.validations;

import br.com.alura.forum.domain.ValidationsException;
import br.com.alura.forum.domain.topic.TopicData;
import br.com.alura.forum.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicExists implements ValidatorTopicService{
    @Autowired
    private TopicRepository topicRepository;

    public void validate(TopicData data) {
        if (topicRepository.existsByTitle(data.title())) {
            throw new ValidationsException("Tópico já casdastrado anteriormente");
        }
        if (topicRepository.existsByMessage(data.message())) {
            throw new ValidationsException("Mensagem já cadastrada anteriormente");
        }
    }
}
