package br.project.atendimentos.api.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "SERVICO")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservico")
    private Integer idServico;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    @Column(name = "preco", nullable = false)
    private Double preco;
    @ManyToMany
    @JoinTable(
            name = "servico_profissional", // nome da tabela associativa
            joinColumns = @JoinColumn(name = "idservico", nullable = false), // foreign key para a tabela de serviço
            inverseJoinColumns = @JoinColumn(name = "idprofissional", nullable = false)) // foreign key para a tabela de profissional
    private List<Profissional> profissionais;
    @OneToMany(mappedBy = "servico")
    private List<Atendimento> atendimentos;
}
