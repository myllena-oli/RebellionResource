package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Rebelde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private Double carteira;
    private boolean traidor;
    private int denuncias;

    @OneToMany(mappedBy = "rebelde", cascade = CascadeType.ALL)
    @JoinColumn(name = "rebelde_id")
    private List<Inventario> inventario = new ArrayList<>();

}