package br.com.alura.forum.domain.topic.validations;

import br.com.alura.forum.domain.topic.TopicData;

public interface TopicValidator {
    void validate(TopicData data);
}
