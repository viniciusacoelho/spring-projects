package br.com.viniciusacoelho.project_name.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(unique = true, length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(unique = true, length = 50, nullable = false)
    private String cpf;

    @Column(length = 50, nullable = false)
    private String cep;

    @Column(length = 100, nullable = false)
    private String password;

}
