package br.project.atendimentos.api.entities;


import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "PROFISSIONAL")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofissional")
    private Integer idProfissional;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    @Column(name = "telefone", length = 16, nullable = false, unique = true)
    private String telefone;
    @ManyToMany(mappedBy = "profissionais")
    private List<Servico> servicos;
}
