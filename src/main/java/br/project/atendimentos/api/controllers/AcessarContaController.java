package br.project.atendimentos.api.controllers;

import br.project.atendimentos.api.entities.Cliente;
import br.project.atendimentos.api.helpers.MD5Helper;
import br.project.atendimentos.api.repositories.IClienteRepository;
import br.project.atendimentos.api.requests.AcessarContaPostRequest;
import br.project.atendimentos.api.security.TokenSecurity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

@Transactional
@Controller
public class AcessarContaController {

    @Autowired
    private IClienteRepository clienteRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para autenticação de clientes.")
    @RequestMapping(value = "/api/acessar-conta", method = RequestMethod.POST)
    public ResponseEntity<String> post(@RequestBody AcessarContaPostRequest request ) {

        try {

            Cliente cliente = clienteRepository.findByCpfAndSenha
                    (request.getCpf(), MD5Helper.encrypt(request.getSenha()));

            if(cliente == null) //Se o cliente NÃO foi encontradp
                throw new IllegalArgumentException("Acesso negado, cpf e senha inválidos.");

            //HTTP 200 (OK)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(TokenSecurity.generateToken(cliente.getCpf()));
        }
        catch(IllegalArgumentException e) {
            //HTTP 401 (CLIENT ERROR) -> UNAUTHORIZED
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
        catch(Exception e) {
            //HTTP 500 (SERVER ERROR) -> INTERNAL SERVER ERROR
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
