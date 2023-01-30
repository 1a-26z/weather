package com.example.provider.service;

import com.example.provider.exception.ResourceNotFoundException;
import com.example.provider.pojo.Provider;
import com.example.provider.repository.ProviderRepository;
import com.example.provider.repository.ProviderRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }


    @Override
    public Provider findById(String s) {
        Optional<Provider> providerInfo = providerRepository.findById(s);
        if (providerInfo.isPresent()) {
            return providerInfo.get();
        } else {
            throw new ResourceNotFoundException("provider not found");
        }
    }

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider createProvider(Provider entity) {
        return providerRepository.save(entity);
    }
}

class ProviderServiceImplTest {
    private static ProviderService providerService;

    @BeforeAll
    public static void init() {
        providerService = new ProviderServiceImpl(new ProviderRepositoryImpl());
    }

    @Autowired
    public ProviderServiceImplTest(ProviderService providerService) {
        this.providerService = providerService;
        providerService.createProvider(new Provider("1", "F", "L", "M", "2023/01/23"));
    }

    @Test
    public void nullInput() {
        assertThrows(ResourceNotFoundException.class, () -> providerService.findById("2"));
    }

    @Test
    public void validInput() {
        assertEquals(providerService.findById("1").getDob(), "2023/01/23");
        assertEquals(providerService.findAll().size(), 1);
    }
}
