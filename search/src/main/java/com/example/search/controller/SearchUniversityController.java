package com.example.search.controller;

import com.example.search.domain.dto.ProviderDTO;
import com.example.search.domain.dto.ProviderResponseDTO;
import com.example.search.domain.dto.StudentDTO;
import com.example.search.domain.dto.StudentResponseDTO;
import com.example.search.service.SearchService;
import com.example.search.service.SearchServiceProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/search/university")
public class SearchUniversityController {
    private final SearchService searchService;

    @Autowired
    public SearchUniversityController(SearchService universityService) {
        this.searchService = universityService;
    }

//    ??????????????????????????????????????????????

    @GetMapping
    public ResponseEntity<StudentResponseDTO> getAllStudents() throws ExecutionException, InterruptedException {
        //TODO
        return new ResponseEntity<StudentResponseDTO>((StudentResponseDTO) searchService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) throws ExecutionException, InterruptedException {
        //TODO
        return new ResponseEntity<StudentDTO>((StudentDTO) searchService.getById(id), HttpStatus.OK);
    }

}
