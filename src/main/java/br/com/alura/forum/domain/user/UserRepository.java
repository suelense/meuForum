package br.com.alura.forum.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);
}
