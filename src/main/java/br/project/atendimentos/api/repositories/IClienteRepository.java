package br.project.atendimentos.api.repositories;

import br.project.atendimentos.api.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

    @Query("select c from Cliente c where c.cpf = :param1")
    Cliente findByCpf(@Param("param1") String cpf)
            throws Exception;

    @Query("select c from Cliente c where c.email = :param1")
    Cliente findByEmail(@Param("param1") String email)
            throws Exception;

    @Query("select c from Cliente c where c.cpf = :param1 and c.senha = :param2")
    Cliente findByCpfAndSenha(@Param("param1") String cpf,
    @Param("param2") String senha) throws Exception;


}
