package br.com.alura.forum.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(name = "profile")
    @Enumerated(EnumType.STRING)
    private Profile profile;

    public User(UserData data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
        this.profile = data.profile();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
