package com.example.search.service;

import com.example.search.domain.dto.ProviderDTO;
import com.example.search.domain.dto.ProviderResponseDTO;
import com.example.search.domain.entity.Provider;
import com.example.search.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service("providerService")
public class SearchServiceProviderImpl implements SearchService{
    private String url = "http://localhost:8300";

    private final RestTemplate restTemplate;

    @Autowired
    public SearchServiceProviderImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public ProviderResponseDTO getAll() throws ExecutionException, InterruptedException {
        CompletableFuture<ProviderResponseDTO> responseDTOFuture = CompletableFuture.supplyAsync(() -> {
            List<Provider> providerList = restTemplate.getForObject(url, List.class);
            List<ProviderDTO> providerDTOS = providerList
                    .stream()
                    .map(provider -> new ProviderDTO((Provider) provider))
                    .collect(Collectors.toList());
            return new ProviderResponseDTO(providerDTOS);
        });
        return responseDTOFuture.get();
    }

    @Override
    public ProviderDTO getById(String id) throws ExecutionException, InterruptedException {
        CompletableFuture<ProviderDTO> providerDTOFuture = CompletableFuture.supplyAsync(() -> {
            Provider provider = restTemplate.getForObject(url + "/" + id, Provider.class);
            if (provider == null) {
                throw new ResourceNotFoundException("no provider found");
            }
            return new ProviderDTO(provider);
        });
        return providerDTOFuture.get();
    }
}
