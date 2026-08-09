package br.com.viniciusacoelho.project_name.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UserDTORecord() {

    @NotBlank(message = "O nome não deve ser vazio!")
    @Size(min = 3, max = 50, message = "O nome deve ter no mínimo ${min} e no máximo ${max} caracteres.")
    private static String name;

    @NotBlank(message = "O e-mail não deve ser vazio!")
    @Size(min = 3, max = 50, message = "O email deve ter no mínimo ${min} e no máximo ${max} caracteres.")
    @Email
    private static String email;

    @NotBlank(message = "O usuário não deve ser vazio!")
    @Size(min = 3, max = 50, message = "O usuário deve ter no mínimo ${min} e no máximo ${max} caracteres.")
    private static String username;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private static LocalDate birthDate;

    @NotBlank(message = "O CPF não deve ser vazio!")
    @CPF(message = "CPF ${cpf} inválido!")
    private static String cpf;

    @NotBlank(message = "O CEP não deve ser vazio!")
    private static String cep;

    @NotBlank(message = "A senha não deve ser vazia!")
    private static String password;

}
