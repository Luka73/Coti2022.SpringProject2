package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Servico;
import org.springframework.data.repository.CrudRepository;

public interface IServicoRepository extends CrudRepository<Servico, Integer> {
}
