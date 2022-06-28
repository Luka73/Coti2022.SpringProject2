package br.project.atendimentos.api.responses;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfissionalGetResponse {
    private Integer idProfissional;
    private String nome;
    private String telefone;
}
