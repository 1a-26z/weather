package com.example.provider.service;

import com.example.provider.pojo.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProviderService {
    Provider findById(String s);

    List<Provider> findAll();

    Provider createProvider(Provider entity);
}
