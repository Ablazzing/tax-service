package com.javaacademy.tax_service.tax_objects;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    @NonNull
    private String fullName;
    @NonNull
    private String email;
}
