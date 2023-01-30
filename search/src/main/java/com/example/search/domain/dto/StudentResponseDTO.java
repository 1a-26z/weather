package com.example.search.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private List<StudentDTO> employeeList;
}
