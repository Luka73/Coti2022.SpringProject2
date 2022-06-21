package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Atendimento;
import org.springframework.data.repository.CrudRepository;

public interface IAtendimentoRepository extends CrudRepository<Atendimento, Integer> {
}
