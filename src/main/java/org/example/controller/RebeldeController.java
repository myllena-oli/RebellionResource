package org.example.controller;

import org.example.model.Rebelde;
import org.example.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rebelde")
public class RebeldeController {

    @Autowired
    private RebeldeService rebeldeService;

    @PostMapping
    public Rebelde adicionarRebelde(@RequestBody Rebelde rebelde){
        return rebeldeService.adicionarRebelde(rebelde);
    }

    @GetMapping
    public List<Rebelde> listarRebeldes(){
        return rebeldeService.listarRebeldes();
    }

    @PutMapping("/{id}")
    public Rebelde atualizarLocalizacao(@PathVariable Long rebeldeId, @RequestBody String novaLocalizacao){
        return rebeldeService.atualizarLocalizacao(rebeldeId, novaLocalizacao);
    }

    @PutMapping("/atualizar-traidor/{id}")
    public Rebelde reportarTraidor(@PathVariable Long rebeldeId){
        return rebeldeService.reportarTraidor(rebeldeId);
    }

    @GetMapping("/porcentagem-traidores")
    public double calcularPorcentagemTraidores(){
        return rebeldeService.calcularPorcentagemTraidores();
    }
    @GetMapping("/porcentagem-rebeldes")
    public double calcularPorcentagemRebeldes(){
        return rebeldeService.calcularPorcentagemRebeldes();
    }

    @PutMapping("/atualizar-inventario/{id}")
    public Rebelde comprarItem(@PathVariable Long rebeldeId, @RequestParam String item, @RequestParam int quantidade){
        return rebeldeService.comprarItem(rebeldeId, item, quantidade);

    }

}
