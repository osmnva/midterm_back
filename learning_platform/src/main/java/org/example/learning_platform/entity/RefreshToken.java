package org.example.learning_platform.entity;

import jakarta.persistence.*;
import org.example.learning_platform.service.RefreshTokenService;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
public class RefreshToken {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String token;
    @OneToOne private User user;
    private Instant expiryDate;

    public void setToken(String token) {
    }

    public void setUser(User user) {
    }

    public void setUser(LocalDateTime localDateTime) {
    }

    public Instant getExpiryDate() {
        return null;
    }

    public RefreshTokenService getUser() {
        return null;
    }

    public void setExpiryDate(LocalDateTime localDateTime) {
    }
}