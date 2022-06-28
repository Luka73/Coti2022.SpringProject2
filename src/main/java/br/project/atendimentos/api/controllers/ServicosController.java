package br.project.atendimentos.api.controllers;

import br.project.atendimentos.api.entities.Profissional;
import br.project.atendimentos.api.entities.Servico;
import br.project.atendimentos.api.repositories.IServicoRepository;
import br.project.atendimentos.api.responses.ProfissionalGetResponse;
import br.project.atendimentos.api.responses.ServicoGetResponse;
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
public class ServicosController {

    @Autowired
    private IServicoRepository servicoRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para consulta de serviços.")
    @RequestMapping(value = "/api/servicos", method = RequestMethod.GET)
    public ResponseEntity<List<ServicoGetResponse>> get() {
        try {
            List<ServicoGetResponse> lista = new ArrayList<>();
            for (Servico servico : servicoRepository.findAll()) {
                ServicoGetResponse servicoResponse = new ServicoGetResponse();
                servicoResponse.setIdServico(servico.getIdServico());
                servicoResponse.setNome(servico.getNome());
                servicoResponse.setPreco(servico.getPreco());
                for(Profissional profissional : servico.getProfissionais()) {
                    ProfissionalGetResponse profissionalResponse = new ProfissionalGetResponse();
                    profissionalResponse.setIdProfissional(profissional.getIdProfissional());
                    profissionalResponse.setNome(profissional.getNome());
                    profissionalResponse.setTelefone(profissional.getTelefone());
                    servicoResponse.getProfissionais().add(profissionalResponse);
                }

                lista.add(servicoResponse);
            }
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
