package gm.rh.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean enabled = false;  // Indica si el usuario ha activado su cuenta

    private String verificationToken; // Token para verificar el email

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // campo para los roles
}