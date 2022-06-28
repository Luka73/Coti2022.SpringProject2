package br.project.atendimentos.api.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AtendimentoPostRequest {
    private Integer idServico;
    private String data;
    private String hora;
    private String observacoes;
}
