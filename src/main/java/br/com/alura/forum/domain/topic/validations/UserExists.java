package br.com.alura.forum.domain.topic.validations;

import br.com.alura.forum.domain.ValidationsException;
import br.com.alura.forum.domain.topic.TopicData;
import br.com.alura.forum.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserExists implements TopicValidator {
    @Autowired
    private UserRepository userRepository;

    public void validate(TopicData data) {
        if (!userRepository.existsById(data.user_id())) {
            throw new ValidationsException("Id do usuário não existe");
        }
    }
}
