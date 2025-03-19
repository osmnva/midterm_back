package org.example.learning_platform.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class InstructorDtoTest {

    @Test
    void testGettersAndSetters() {
        InstructorDto instructorDto = new InstructorDto();

        instructorDto.setId(1L)
                     .setName("John Doe")
                     .setEmail("john.doe@example.com")
                     .setBio("Experienced instructor in computer science.")
                     .setRegistrationDate(LocalDate.of(2023, 10, 1));

        assertEquals(1L, instructorDto.getId());
        assertEquals("John Doe", instructorDto.getName());
        assertEquals("john.doe@example.com", instructorDto.getEmail());
        assertEquals("Experienced instructor in computer science.", instructorDto.getBio());
        assertEquals(LocalDate.of(2023, 10, 1), instructorDto.getRegistrationDate());
    }

    @Test
    void testEqualsAndHashCode() {
        InstructorDto instructorDto1 = new InstructorDto()
                .setId(1L)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setBio("Experienced instructor in computer science.")
                .setRegistrationDate(LocalDate.of(2023, 10, 1));

        InstructorDto instructorDto2 = new InstructorDto()
                .setId(1L)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setBio("Experienced instructor in computer science.")
                .setRegistrationDate(LocalDate.of(2023, 10, 1));

        assertEquals(instructorDto1, instructorDto2);
        assertEquals(instructorDto1.hashCode(), instructorDto2.hashCode());
    }

    @Test
    void testToString() {
        InstructorDto instructorDto = new InstructorDto()
                .setId(1L)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setBio("Experienced instructor in computer science.")
                .setRegistrationDate(LocalDate.of(2023, 10, 1));

        String expectedToString = "InstructorDto{id=1, name='John Doe', email='john.doe@example.com', bio='Experienced instructor in computer science.', registrationDate=2023-10-01}";
        assertEquals(expectedToString, instructorDto.toString());
    }

    @Test
    void testNullValues() {
        InstructorDto instructorDto = new InstructorDto()
                .setId(null)
                .setName(null)
                .setEmail(null)
                .setBio(null)
                .setRegistrationDate(null);

        assertNull(instructorDto.getId());
        assertNull(instructorDto.getName());
        assertNull(instructorDto.getEmail());
        assertNull(instructorDto.getBio());
        assertNull(instructorDto.getRegistrationDate());
    }
}