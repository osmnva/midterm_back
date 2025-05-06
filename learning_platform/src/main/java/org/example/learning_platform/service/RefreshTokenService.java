package org.example.learning_platform.service;

import org.example.learning_platform.entity.RefreshToken;
import org.example.learning_platform.entity.User;
import org.example.learning_platform.repository.RefreshTokenRepository;
import org.example.learning_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepo;
    private final UserRepository userRepo;
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepo, UserRepository userRepo, RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepo = refreshTokenRepo;
        this.userRepo = userRepo;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public String createRefreshToken(String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        String token = UUID.randomUUID().toString();
        RefreshToken rt = new RefreshToken();
        rt.setToken(token);
        rt.setUser(user);
        rt.setExpiryDate(LocalDateTime.now().plusDays(7));
        refreshTokenRepo.save(rt);
        return token;
    }

    public boolean validate(String token) {
        return refreshTokenRepo.findByToken(token)
                .filter(rt -> rt.getExpiryDate().isAfter(Instant.from(LocalDateTime.now())))
                .isPresent();
    }

    public String getUsername(String token) {
        return refreshTokenRepo.findByToken(token)
                .map(rt -> rt.getUser().getUsername(token))
                .orElse(null);
    }

    public boolean isValid(String token) {
        return validate(token);
    }
}