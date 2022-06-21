package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Profissional;
import org.springframework.data.repository.CrudRepository;

public interface IProfissionalRepository extends CrudRepository<Profissional, Integer> {
}
