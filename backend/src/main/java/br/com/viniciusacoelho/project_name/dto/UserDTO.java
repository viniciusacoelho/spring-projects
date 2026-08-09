package br.com.viniciusacoelho.project_name.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull(message = "O nome não deve ser vazio!")
    @Size(min = 3, max = 50, message = "O nome deve ter no mínimo ${min} e no máximo ${max} caracteres.")
    private String name;

    @NotBlank(message = "O e-mail não deve ser vazio!")
    @Size(min = 3, max = 50, message = "O email deve ter no mínimo ${min} e no máximo ${max} caracteres.")
    @Email(message = "E-mail ${email} inválido!")
    private String email;

    @NotBlank(message = "O usuário não deve ser vazio!")
    @Size(min = 3, max = 50, message = "O usuário deve ter no mínimo ${min} e no máximo ${max} caracteres.")
    private String username;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotBlank(message = "O CPF não deve ser vazio!")
    @CPF(message = "CPF ${cpf} inválido!")
    private String cpf;

    @NotBlank(message = "O CEP não deve ser vazio!")
    private String cep;

    @NotBlank(message = "A senha não deve ser vazia!")
    private String password;

}
