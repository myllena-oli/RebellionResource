package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long id;
    private String nome;
    private int quantidade;
    //  @ManyToOne
    @ManyToOne
    @JoinColumn(name = "id_rebelde", referencedColumnName = "id_rebelde")
    private Rebelde rebelde;
}
