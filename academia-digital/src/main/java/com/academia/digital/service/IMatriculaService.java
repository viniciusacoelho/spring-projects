package com.academia.digital.service;

import com.academia.digital.entity.Matricula;
import com.academia.digital.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {

    Matricula create(MatriculaForm form);

    Matricula get(Long id);

    List<Matricula> getAll();

    List<Matricula> getAll(String bairro);

    void delete(Long id);

}
