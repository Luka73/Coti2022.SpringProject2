package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface IEnderecoRepository extends CrudRepository<Endereco, Integer> {
}
