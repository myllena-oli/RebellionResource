package org.example.model;


import java.util.HashMap;
import java.util.Map;

public class BaseDeCompras {
    private Map<String, Double> itens;

    public BaseDeCompras() {
        itens = new HashMap<>();
        itens.put("Arma", 100.0);
        itens.put("Munição", 30.0);
        itens.put("Água", 5.0);
        itens.put("Comida", 15.0);
    }

    public double getPrecoItem(String item) {
        return itens.getOrDefault(item, 0.0);
    }
}

