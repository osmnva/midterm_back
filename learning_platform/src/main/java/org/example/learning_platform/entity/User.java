package org.example.learning_platform.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.context.support.BeanDefinitionDsl;

import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String name;
    private boolean emailVerified = false;
    private boolean twoFactorEnabled = false;
    private String secret2FA;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    private boolean enabled;

    public String getUsername() {
        return null;
    }

    public void setPassword(String encode) {
    }

    public CharSequence getPassword() {
        return null;
    }

    public void setRoles(List<BeanDefinitionDsl.Role> roleUser) {
    }

    public String getEmail() {
        return null;
    }

    public Collection<Object> getRoles() {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String email) {
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}