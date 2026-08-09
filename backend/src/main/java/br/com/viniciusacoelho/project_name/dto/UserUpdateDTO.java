package br.com.viniciusacoelho.project_name.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UserUpdateDTO(

        @Size(min = 3, max = 50, message = "O nome deve ter no mínimo {min} e no máximo {max} caracteres.")
        String name,

        @Size(min = 3, max = 50, message = "O email deve ter no mínimo {min} e no máximo {max} caracteres.")
        @Email(message = "E-mail {email} inválido!")
        String email,

        @Size(min = 3, max = 50, message = "O usuário deve ter no mínimo {min} e no máximo {max} caracteres.")
        String username,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,

        @CPF(message = "CPF inválido!")
        String cpf,

        String cep,

        String password

) {}
