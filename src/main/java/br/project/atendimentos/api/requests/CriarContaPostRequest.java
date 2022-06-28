package br.project.atendimentos.api.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CriarContaPostRequest {

    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private String telefone;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}
