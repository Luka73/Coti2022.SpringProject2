package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Servico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IServicoRepository extends CrudRepository<Servico, Integer> {

    @Query("select distinct s from Servico s join s.profissionais order by s.idServico")
    public List<Servico> findAll();
}
