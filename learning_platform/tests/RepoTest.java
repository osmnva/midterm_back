package org.example.learning_platform.tests;

import org.example.learning_platform.entity.Category;
import org.example.learning_platform.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class RepoTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testIsIdExist() {
        Category category = new Category();
        category.setName("Programming");
        categoryRepository.save(category);

        assertTrue(categoryRepository.isIdExist(category.getId()));
        assertFalse(categoryRepository.isIdExist(999L));
    }

    @Test
    public void testFindByName() {
        Category category = new Category();
        category.setName("Programming");
        categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findByName("Programming");
        assertTrue(foundCategory.isPresent());
        assertEquals("Programming", foundCategory.get().getName());
    }
}