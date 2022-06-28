package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Atendimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAtendimentoRepository extends CrudRepository<Atendimento, Integer> {

    @Query("select a from Atendimento a where a.cliente.idCliente = :param1")
    public List<Atendimento> findByCliente(@Param("param1") Integer idCliente) throws Exception;
}
