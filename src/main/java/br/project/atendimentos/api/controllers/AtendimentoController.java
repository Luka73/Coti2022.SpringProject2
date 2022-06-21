package br.project.atendimentos.api.controllers;

import javax.transaction.Transactional;

import br.project.atendimentos.api.repositories.IAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

@Transactional
@Controller
public class AtendimentoController {

    @Autowired
    private IAtendimentoRepository atendimentoRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para o cliente cadastrar um atendimento.")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.POST)
    public ResponseEntity<String> post() {
        return null;
    }

    @CrossOrigin
    @ApiOperation("Endpoint para o cliente consultar os atendimentos agendados.")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.GET)
    public ResponseEntity<String> get() {
        return null;
    }

}
