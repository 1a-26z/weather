package com.example.search.domain.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider {

    private String id;

    private String first_name;

    private String last_name;

    private String middle_name;

    private String dob;
}
