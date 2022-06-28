package br.project.atendimentos.api.responses;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicoGetResponse {
    private Integer idServico;
    private String nome;
    private Double preco;
    private List<ProfissionalGetResponse> profissionais;
}
