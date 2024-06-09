package br.com.alura.forum.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserData(@NotBlank String name,
                       @NotBlank String email,
                       @NotBlank String password,
                       @NotNull Profile profile) {
}
