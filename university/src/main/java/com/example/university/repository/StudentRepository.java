package com.example.university.repository;

import com.example.university.pojo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(String id);

    List<Student> findAll();

    Student save(Student student);

    @Override
    void deleteById(Integer id);
}
