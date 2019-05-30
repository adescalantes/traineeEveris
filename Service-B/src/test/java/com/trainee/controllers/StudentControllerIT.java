package com.trainee.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.trainee.repositories.StudentRepository;
import com.trainee.services.IStudentService;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIT {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private StudentController studentController;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private IStudentService studentService;

  @Test
  void testGetAll() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/v1/students").accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(jsonPath("[*].id").exists()).andExpect(jsonPath("[*].gender").exists())
        .andExpect(jsonPath("[*].firstName").exists()).andExpect(jsonPath("[*].lastName").exists())
        .andExpect(jsonPath("[*].middleName").exists()).andExpect(jsonPath("[*].dateOfBirth").exists());
  }

//	@Test
//	void testPost() throws Exception{
//		Student student = new Student(1, "mock", "mock", "mock", "mock", new Date(1995-05-05), "mock");
//		mvc.perform(post("/students", 42L)
//		        .contentType("application/json")
//		        .param("sendWelcomeMail", "true")
//		        .content(objectMapper.writeValueAsString(user)))
//		        .andExpect(status().isOk());
//				
//				
//
//	}

}
