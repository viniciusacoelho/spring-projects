package com.academia.digital.service;

import com.academia.digital.entity.Aluno;
import com.academia.digital.entity.AvaliacaoFisica;
import com.academia.digital.entity.form.AlunoForm;
import com.academia.digital.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {

    Aluno create(AlunoForm form);

    Aluno get(Long id);

    List<Aluno> getAll();

    List<Aluno> getAll(String dataDeNascimento); // na interface vou receber uma String dataDeNascimento

    Aluno update(Long id, AlunoUpdateForm formUpdate);

    void delete(Long id);

    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);

}
