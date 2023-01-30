package com.example.search.controller;

import com.example.search.domain.dto.ProviderDTO;
import com.example.search.domain.dto.ProviderResponseDTO;
import com.example.search.domain.dto.StudentDTO;
import com.example.search.domain.dto.StudentResponseDTO;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/search/provider")
public class SearchProviderController {
    private final SearchService searchService;

    @Autowired
    public SearchProviderController(SearchService providerService) {
        this.searchService = providerService;
    }

    @GetMapping
    public ResponseEntity<ProviderResponseDTO> getAllProviders() throws ExecutionException, InterruptedException {
        //TODO
        return new ResponseEntity<ProviderResponseDTO>((ProviderResponseDTO) searchService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> getProviderById(@PathVariable String id) throws ExecutionException, InterruptedException {
        //TODO
        return new ResponseEntity<ProviderDTO>((ProviderDTO) searchService.getById(id), HttpStatus.OK);
    }
}

