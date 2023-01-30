package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface SearchService {
    public Object getAll() throws ExecutionException, InterruptedException;

    public Object getById(String id) throws ExecutionException, InterruptedException;
}
