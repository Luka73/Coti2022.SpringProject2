package br.project.atendimentos.api.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCLIENTE")
    private Integer idCliente;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    @Column(name = "senha", length = 40, nullable = false)
    private String senha;
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "telefone", length = 16, nullable = false)
    private String telefone;
    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;
    @OneToMany(mappedBy = "cliente")
    private List<Atendimento> atendimentos;
}
