package org.example.model;

import javax.persistence.*;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;
    @ManyToOne
    private Rebelde rebelde;
}
