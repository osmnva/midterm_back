package org.example.learning_platform.repository;

import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<BeanDefinitionDsl.Role, Long> {
    Optional<BeanDefinitionDsl.Role> findByName(String name);
}

