package com.joakim.freelancertoolkitbackend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name= "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
}
