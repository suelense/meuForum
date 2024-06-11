package br.com.alura.forum.infra.security;

public record AuthenticationDTO(String email,
                                String password) {
}
