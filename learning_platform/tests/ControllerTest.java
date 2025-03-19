package org.example.learning_platform.controller;

import org.example.learning_platform.dto.Response;
import org.example.learning_platform.dto.StudentDto;
import org.example.learning_platform.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

class StudentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void testGetStudentByName() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("John Doe");
        List<StudentDto> students = Collections.singletonList(studentDto);

        when(studentService.getStudentByName("John Doe")).thenReturn(students);

        mockMvc.perform(get("/student/get-student-by-name/John Doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Successfully retrieved Student."))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"))
                .andDo(print());

        verify(studentService, times(1)).getStudentByName("John Doe");
    }

    @Test
    void testGetStudentByName_NotFound() throws Exception {
        when(studentService.getStudentByName("Unknown")).thenThrow(new RuntimeException("Student not found"));

        mockMvc.perform(get("/student/get-student-by-name/Unknown"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Failed to retrieve Student. Student not found"))
                .andDo(print());

        verify(studentService, times(1)).getStudentByName("Unknown");
    }

    @Test
    void testGetStudentByCourseId() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("John Doe");
        List<StudentDto> students = Collections.singletonList(studentDto);

        when(studentService.getStudentsByCourseId(1L)).thenReturn(students);

        mockMvc.perform(get("/student/get-student-by-course-id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Successfully retrieved Students."))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"))
                .andDo(print());

        verify(studentService, times(1)).getStudentsByCourseId(1L);
    }

    @Test
    void testGetAllStudent() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("John Doe");
        List<StudentDto> students = Collections.singletonList(studentDto);

        when(studentService.getAllStudents()).thenReturn(students);

        mockMvc.perform(get("/student/get-all-student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Successfully retrieved all Students."))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"))
                .andDo(print());

        verify(studentService, times(1)).getAllStudents();
    }

    @Test
    void testCreateStudent() throws Exception {
        StudentDto request = new StudentDto();
        request.setName("John Doe");

        StudentDto response = new StudentDto();
        response.setName("John Doe");

        when(studentService.createStudent(request)).thenReturn(response);

        mockMvc.perform(post("/student/create-student")
                        .contentType("application/json")
                        .content("{\"name\": \"John Doe\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Successfully created Student."))
                .andExpect(jsonPath("$.data.name").value("John Doe"))
                .andDo(print());

        verify(studentService, times(1)).createStudent(request);
    }

    @Test
    void testUpdateStudent() throws Exception {
        StudentDto request = new StudentDto();
        request.setName("John Doe");

        StudentDto response = new StudentDto();
        response.setName("John Doe");

        when(studentService.updateStudent(request)).thenReturn(response);

        mockMvc.perform(put("/student/update-student")
                        .contentType("application/json")
                        .content("{\"name\": \"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Updated Student successfully."))
                .andExpect(jsonPath("$.data.name").value("John Doe"))
                .andDo(print());

        verify(studentService, times(1)).updateStudent(request);
    }

    @Test
    void testSortByName() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("John Doe");
        List<StudentDto> students = Collections.singletonList(studentDto);

        when(studentService.sortByName()).thenReturn(students);

        mockMvc.perform(get("/student/sort-by-name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Successfully retrieved sorted Students."))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"))
                .andDo(print());

        verify(studentService, times(1)).sortByName();
    }
}
