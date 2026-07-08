package com.taskflow.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Email(message = "E-mail inválido.")
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres.")
    @NotBlank(message = "A senha é obrigatória.")
    private String password;
}
