package com.project.dev.dto;

import com.project.dev.entities.User;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    public UserDTO(Long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        birthDate = entity.getBirthDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}