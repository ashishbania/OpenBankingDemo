package com.example.demo.SpringBootDemo;

import com.example.demo.OpenBankingDemo.student.Student;
import com.example.demo.OpenBankingDemo.student.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTestRepository {
    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void testSaveStudent(){
//        Student student = new Student();
//        student.setId(11L);
//        student.setName("testname");
//        student.setDob(LocalDate.of(1988, 12,24));
//        student.setEmail("test@test.com");
//        studentRepo.save(new Student(11L,"testName", LocalDate.of(1988,12,24),"ashish.bania@gmail.com"));
        Student dbStudent = studentRepo.findById(1L).get();
        assertNotNull(dbStudent);
    }
}
