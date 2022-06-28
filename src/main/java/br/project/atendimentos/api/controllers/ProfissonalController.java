package br.project.atendimentos.api.controllers;

import br.project.atendimentos.api.entities.Profissional;
import br.project.atendimentos.api.repositories.IProfissionalRepository;
import br.project.atendimentos.api.responses.ProfissionalGetResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller
public class ProfissonalController {

    @Autowired
    private IProfissionalRepository profissionalRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para consulta de profissionais.")
    @RequestMapping(value = "/api/profissionais", method = RequestMethod.GET)
    public ResponseEntity<List<ProfissionalGetResponse>> get() {
        try {
            List<ProfissionalGetResponse> lista = new ArrayList<>();
            for(Profissional profissional : profissionalRepository.findAll()) {
                ProfissionalGetResponse response = new ProfissionalGetResponse();
                response.setIdProfissional(profissional.getIdProfissional());
                response.setNome(profissional.getNome());
                response.setTelefone(profissional.getTelefone());
                lista.add(response);

                return ResponseEntity.status(HttpStatus.OK).body(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return null;
    }
}
