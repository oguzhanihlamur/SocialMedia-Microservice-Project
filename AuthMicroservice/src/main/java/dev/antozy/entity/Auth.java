package dev.antozy.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    @NonNull
    String userName;

    @Column(unique = true, nullable = false)
    String email;

    String password;
    Boolean isActive;
    Long createAt;
}
