package br.com.alura.forum.controller;

import br.com.alura.forum.domain.user.User;
import br.com.alura.forum.domain.user.UserData;
import br.com.alura.forum.domain.user.UserRepository;
import br.com.alura.forum.infra.security.AuthenticationDTO;
import br.com.alura.forum.infra.security.TokenDTO;
import br.com.alura.forum.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
            throw new RuntimeException(("Erro: Email já cadastrado!"));
        }
    }

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationDTO.email(),
                authenticationDTO.password()
        );
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.setToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }
}
