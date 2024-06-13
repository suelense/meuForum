package br.com.alura.forum.domain.user;

public record UserDTO(Long id,
                      String name,
                      String email) {
    public UserDTO(User user) {
        this(user.getId(),
                user.getUsername(),
                user.getEmail());
    }
}
