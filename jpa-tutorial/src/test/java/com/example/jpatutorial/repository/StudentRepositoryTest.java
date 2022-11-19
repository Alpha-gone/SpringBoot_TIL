package com.example.jpatutorial.repository;

import com.example.jpatutorial.entity.Guardian;
import com.example.jpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("test2@gmail.com")
                .firstName("firstNameTest")
                .lastName("lastNameTest")
//                .guardianName("guardianNameTest")
//                .guardianEmail("guardian@gmail.com")
//                .guardianMobile("1111111111")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWitheGuardian(){
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .name("guardianNameTest")
                .mobile("22222222222")
                .build();

        Student student = Student.builder()
                .firstName("guardianFirstNameTest")
                .emailId("guardianNameTest@gmail.com")
                .lastName("guardianLastNameTest")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("firstNameTest");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Test");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("guardianNameTest");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printGetStudentsByEmailAddress(){
        Student student = studentRepository.getStudentsByEmailAddress("guardianNameTest@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentsFirstNameByEmailAddress("test@gmail.com");

        System.out.println("firstName = " + firstName);

    }

    @Test
    public void printGetStudentsByEmailAddressNative(){
        Student student = studentRepository.getStudentsByEmailAddressNative("test@gmail.com");

        System.out.println("student = " + student);
    }


    @Test
    public void printGetStudentsByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentsByEmailAddressNativeNamedParam("test@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("updateTest","test@gmail.com");
    }
}