package br.project.atendimentos.api.controllers;

import javax.transaction.Transactional;

import br.project.atendimentos.api.repositories.IProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

@Transactional
@Controller
public class ProfissonalController {

    @Autowired
    private IProfissionalRepository profissionalRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para consulta de profissionais.")
    @RequestMapping(value = "/api/profissionais", method = RequestMethod.GET)
    public ResponseEntity<String> get() {
        return null;
    }
}
