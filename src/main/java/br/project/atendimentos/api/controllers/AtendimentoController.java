package br.project.atendimentos.api.controllers;

import br.project.atendimentos.api.entities.Atendimento;
import br.project.atendimentos.api.entities.Cliente;
import br.project.atendimentos.api.entities.Servico;
import br.project.atendimentos.api.repositories.IAtendimentoRepository;
import br.project.atendimentos.api.repositories.IClienteRepository;
import br.project.atendimentos.api.repositories.IServicoRepository;
import br.project.atendimentos.api.requests.AtendimentoPostRequest;
import br.project.atendimentos.api.responses.AtendimentoGetResponse;
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

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Controller
public class AtendimentoController {

    @Autowired
    private IAtendimentoRepository atendimentoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IServicoRepository servicoRepository;


    @CrossOrigin
    @ApiOperation("Endpoint para o cliente cadastrar um atendimento.")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.POST)
    public ResponseEntity<String> post(@RequestBody AtendimentoPostRequest request, HttpServletRequest httpRequest) {
        try{
            Cliente cliente = getClienteByAccessToken(httpRequest);
            Servico servico = servicoRepository.findById(request.getIdServico()).get();

            Date dataHora = new SimpleDateFormat("dd/MM/yyyy-HH:mm").parse(request.getData() + "-" + request.getHora());

            Atendimento atendimento = new Atendimento();
            atendimento.setCliente(cliente);
            atendimento.setServico(servico);
            atendimento.setDataHora(dataHora);
            atendimento.setObservacoes(request.getObservacoes());

            atendimentoRepository.save(atendimento);

            return ResponseEntity.status(HttpStatus.CREATED).body("Atendimento cadastrado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @CrossOrigin
    @ApiOperation("Endpoint para o cliente consultar os atendimentos agendados.")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.GET)
    public ResponseEntity<List<AtendimentoGetResponse>> get(HttpServletRequest httpRequest) {

        try{
            Cliente cliente = getClienteByAccessToken(httpRequest);
            List<AtendimentoGetResponse> lista = new ArrayList<>();

            for(Atendimento atendimento : atendimentoRepository.findByCliente(cliente.getIdCliente())) {
                AtendimentoGetResponse response = new AtendimentoGetResponse();
                response.setIdAtendimento(atendimento.getIdAtendimento());
                response.setDataHora(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(atendimento.getDataHora()));
                response.setNomeCliente(atendimento.getServico().getNome());
                response.setPrecoServico(atendimento.getServico().getPreco());
                response.setNomeCliente(atendimento.getCliente().getNome());
                response.setCpfCliente(atendimento.getCliente().getCpf());
                response.setObservacoes(atendimento.getObservacoes());

                lista.add(response);
            }

            return ResponseEntity.status(HttpStatus.OK).body(lista);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private Cliente getClienteByAccessToken(HttpServletRequest httpRequest) throws Exception {
        String accessToken = httpRequest.getHeader("Authorization").replace("Bearer", "").trim();
        String cpf = TokenSecurity.getUserFromToken(accessToken);

        return clienteRepository.findByCpf(cpf);
    }

}
