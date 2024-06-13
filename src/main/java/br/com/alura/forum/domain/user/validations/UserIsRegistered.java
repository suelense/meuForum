package br.com.alura.forum.domain.user.validations;

import br.com.alura.forum.domain.ValidationsException;
import br.com.alura.forum.domain.user.UserData;
import br.com.alura.forum.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserIsRegistered implements ValidatorUserService {
    @Autowired
    private UserRepository userRepository;

    public void validate(UserData data) {
        if (userRepository.existsByEmail(data.email())) {
            throw new ValidationsException("Email já cadastrado anteriormente");
        }
    }
}
