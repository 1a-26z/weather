package com.example.search.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProviderResponseDTO {
    private List<ProviderDTO> providerList;
}
