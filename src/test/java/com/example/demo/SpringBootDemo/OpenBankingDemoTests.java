package com.example.demo.SpringBootDemo;

import com.example.demo.OpenBankingDemo.student.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OpenBankingDemoTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	StudentService studentService;
	@Test
	public void testDependencyInjection(){
		assertNotNull(studentService);
	}

}
