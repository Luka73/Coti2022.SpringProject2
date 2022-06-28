package br.project.atendimentos.api.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    @ManyToOne
    @JoinColumn(name = "idprofissional", nullable = false)
    private Profissional profissional;
}