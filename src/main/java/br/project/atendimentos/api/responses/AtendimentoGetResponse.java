package br.project.atendimentos.api.responses;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AtendimentoGetResponse {
    private Integer idAtendimento;
    private String dataHora;
    private String nomeServico;
    private Double precoServico;
    private String nomeCliente;
    private String cpfCliente;
    private String observacoes;
}
