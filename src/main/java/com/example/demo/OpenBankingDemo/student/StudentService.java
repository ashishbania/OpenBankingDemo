package com.example.demo.OpenBankingDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudent(){
        return studentRepo.findAll();

//        return Arrays.asList();
    }
    @Transactional
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Student already present");
        }
        studentRepo.save(student);
    }
    @Transactional
    public void deleteStudent(Long studentId) {
            boolean exists = studentRepo.existsById(studentId);
            if(!exists){
                throw new IllegalStateException("Student with id"+studentId+"doesn't exist");
            }
            studentRepo.deleteById(studentId);
    }
}
