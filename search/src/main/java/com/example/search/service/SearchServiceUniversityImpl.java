package com.example.search.service;

import com.example.search.domain.dto.StudentDTO;
import com.example.search.domain.dto.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service("universityService")
public class SearchServiceUniversityImpl implements SearchService{
    private String url = "http://localhost:8400";

    private final RestTemplate restTemplate;

    @Autowired
    public SearchServiceUniversityImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public StudentResponseDTO getAll() throws ExecutionException, InterruptedException {
        CompletableFuture<StudentResponseDTO> responseDTOFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject(url, StudentResponseDTO.class));
        return responseDTOFuture.get();
    }

    @Override
    public Object getById(String id) throws ExecutionException, InterruptedException {
        CompletableFuture<StudentDTO> studentDTOFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject(url + "/" + id, StudentDTO.class));
        return studentDTOFuture.get();
    }
}
