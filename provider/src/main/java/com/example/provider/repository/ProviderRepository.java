package com.example.provider.repository;

import com.example.provider.pojo.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, String> {

    @Override
    Optional<Provider> findById(String s);

    @Override
    List<Provider> findAll();

    @Override
    Provider save(Provider entity);
    //?
}
