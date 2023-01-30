package com.example.search.domain.dto;

import com.example.search.domain.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Integer age;

    private String name;

    public StudentDTO(Student s) {
        this.age = s.getAge();
        this.name = s.getName();
    }
}
