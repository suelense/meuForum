package br.com.alura.forum.domain.user;

import br.com.alura.forum.domain.user.validations.ValidatorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private List<ValidatorUserService> validations;

    public UserDTO registerUser(UserData data) {
        validations.forEach(v -> v.validate(data));
        var user = new User(data);
        userRepository.save(user);
        return new UserDTO(user);
    }
}
