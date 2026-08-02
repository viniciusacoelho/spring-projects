package com.academia.digital.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @CPF(message = "'${validatedValue}' é inválido!")
    private String cpf;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String bairro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Preencha o campo corretamente.")
    @Past(message = "Data '${validatedValue}' é inválida.")
    private LocalDate dataDeNascimento;

}
