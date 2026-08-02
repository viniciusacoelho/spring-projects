package com.academia.digital.service;

import com.academia.digital.entity.AvaliacaoFisica;
import com.academia.digital.entity.form.AvaliacaoFisicaForm;
import com.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaForm form);

    AvaliacaoFisica get(Long id);

    List<AvaliacaoFisica> getAll();

    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

    void delete(Long id);

}
