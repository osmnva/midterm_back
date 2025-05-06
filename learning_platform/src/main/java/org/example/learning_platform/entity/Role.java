package org.example.learning_platform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name; // ROLE_ADMIN, ROLE_STUDENT, ROLE_INSTRUCTOR


}