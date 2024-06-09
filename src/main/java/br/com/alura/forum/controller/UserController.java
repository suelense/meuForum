package br.com.alura.forum.controller;

import br.com.alura.forum.domain.user.User;
import br.com.alura.forum.domain.user.UserData;
import br.com.alura.forum.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public void registerUser(@RequestBody @Valid UserData data) throws Exception {
        var user = new User(data);
        if (!repository.existsByEmail(user.getEmail())) {
            repository.save(user);
        } else {
            throw new RuntimeException("Email já cadastrado!");
        }
    }
}
