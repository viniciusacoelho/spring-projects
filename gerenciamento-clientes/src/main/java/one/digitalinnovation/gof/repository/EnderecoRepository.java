package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.Endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
