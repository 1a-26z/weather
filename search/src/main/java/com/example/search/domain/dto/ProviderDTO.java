package com.example.search.domain.dto;

import com.example.search.domain.entity.Provider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProviderDTO {
    private String first_name;

    private String last_name;

    public ProviderDTO(Provider provider) {
        this.first_name = provider.getFirst_name();
        this.last_name = provider.getLast_name();
    }
}
