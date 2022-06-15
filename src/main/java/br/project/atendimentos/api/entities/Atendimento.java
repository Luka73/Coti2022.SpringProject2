package br.project.atendimentos.api.entities;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "ATENDIMENTO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idatendimento")
    private Integer idAtendimento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datahora", nullable = false)
    private Date dataHora;
    @Column(name = "observacoes", length = 500, nullable = false)
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idservico", nullable = false)
    private Servico servico;
}