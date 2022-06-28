package br.project.atendimentos.api.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AcessarContaPostRequest {

    private String cpf;
    private String senha;

}
