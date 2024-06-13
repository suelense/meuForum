package br.com.alura.forum.controller;

import br.com.alura.forum.domain.user.User;
import br.com.alura.forum.domain.user.UserData;
import br.com.alura.forum.domain.user.UserRepository;
import br.com.alura.forum.domain.user.UserService;
import br.com.alura.forum.domain.user.UserDTO;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@RequestBody @Valid UserData data,
                                       UriComponentsBuilder uriComponentsBuilder) {
        var dto = userService.registerUser(data);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(dto.id()).toUri();
        var user = repository.getReferenceById(dto.id());
        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

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
