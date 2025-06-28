package com.example.userservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {
    @NotNull(message = "email cannot be null")
    @Size(min = 2, message = "size must be at least 2 characters")
    @Email
    private String email;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "size must be at least 8 characters")
    private String password;
}
