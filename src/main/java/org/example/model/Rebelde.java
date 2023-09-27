package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rebelde")
public class Rebelde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rebelde")
    private Long id;
    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private Double carteira;
    private boolean traidor;
    private int denuncias;

    @OneToMany(mappedBy = "rebelde", cascade = CascadeType.ALL)
    private List<Inventario> inventario = new ArrayList<>();

}