package com.example.university.service;

import com.example.university.pojo.dto.StudentDTO;
import com.example.university.pojo.dto.StudentResponseDTO;
import com.example.university.pojo.entity.Student;
import com.example.university.repository.StudentRepository;
import com.example.university.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOS = studentList
                .stream()
                .map(s -> new StudentDTO(s))
                .collect(Collectors.toList());
        return new StudentResponseDTO(studentDTOS);
    }

    public StudentDTO getStudentById(String id) {
        //log id
        Student student = studentRepository.findById(id);
        //log employee info
        if(student == null) {
            //log..
            throw new ResourceNotFoundException("student not found");
        }
        return new StudentDTO(student);
    }

    public String createStudent(Student student) {
        return studentRepository.save(student).getId();
    }

    public String updateStudent(Student student) {
        String id = student.getId();
        if (!studentRepository.existsById(Integer.valueOf(id))) {
            //log..
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.save(student);
        return "student updated";
    }

    public String deleteStudentById(String id) {
        if (!studentRepository.existsById(Integer.valueOf(id))) {
            //log..
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.deleteById(Integer.valueOf(id));
        return "student deleted";
    }
}
