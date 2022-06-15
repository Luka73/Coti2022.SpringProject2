package br.project.atendimentos.api.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "ENDERECO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idendereco")
    private Integer idEndereco;
    @Column(name = "logradouro", length = 500, nullable = false)
    private String logradouro;
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    @Column(name = "complemento", length = 100, nullable = false)
    private String complemento;
    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;
    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;
    @Column(name = "estado", length = 2, nullable = false)
    private String uf;
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @OneToOne
    @JoinColumn(name = "idcliente", nullable = false, unique = true)
    private Cliente cliente;

}
