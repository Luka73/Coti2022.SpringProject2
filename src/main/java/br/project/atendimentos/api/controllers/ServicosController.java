package br.project.atendimentos.api.controllers;

import javax.transaction.Transactional;

import br.project.atendimentos.api.repositories.IServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.ApiOperation;

@Transactional
@Controller
public class ServicosController {

    @Autowired
    private IServicoRepository servicoRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para consulta de serviços.")
    @RequestMapping(value = "/api/servicos", method = RequestMethod.GET)
    public ResponseEntity<String> get() {
        return null;
    }
}
