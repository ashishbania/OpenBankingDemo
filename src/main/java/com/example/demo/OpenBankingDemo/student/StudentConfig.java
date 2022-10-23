package com.example.demo.OpenBankingDemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableTransactionManagement
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args -> {
            Student ashish = new Student(
                        1L,
                        "ashish bania",
                        LocalDate.of(1988,12,24),
                        "ashish.banai@gmail.com"
                );
            Student Nairitya =
            new Student(
                    2L,
                    "nairitya ganugly",
                    LocalDate.of(1990,07,01),
                    "ngang90@gmail.com"
            );

            studentRepo.saveAll(Arrays.asList(ashish,Nairitya));
        };
    }

    @Bean
    public StudentService getStudentService(){
        return new StudentService(getStudentRepo());
    }
    @Bean
    public StudentRepo getStudentRepo(){
        return new StudentRepo() {
            @Override
            public Optional<Student> findStudentByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public List<Student> findAll() {
                return null;
            }

            @Override
            public List<Student> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Student> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends Student> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Student> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Student> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Student getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Student> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Student> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Student> S save(S s) {
                return null;
            }

            @Override
            public Optional<Student> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Student student) {

            }

            @Override
            public void deleteAll(Iterable<? extends Student> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Student> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Student> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Student> boolean exists(Example<S> example) {
                return false;
            }
        };
    }
}
