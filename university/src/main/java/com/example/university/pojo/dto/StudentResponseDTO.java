package com.example.university.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private List<StudentDTO> employeeList;
}
