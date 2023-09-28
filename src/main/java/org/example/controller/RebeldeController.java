package org.example.controller;

import org.example.model.Rebelde;
import org.example.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Rebelde atualizarLocalizacao(@PathVariable Long id, @RequestBody String novaLocalizacao){
        return rebeldeService.atualizarLocalizacao(id, novaLocalizacao);
    }

    @PutMapping("/atualizar-traidor/{id}")
    public Rebelde reportarTraidor(@PathVariable Long id){
        return rebeldeService.reportarTraidor(id);
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
    public ResponseEntity<Object> comprarItem(@PathVariable Long id, @RequestParam String item, @RequestParam int quantidade) {
        Optional<Rebelde> rebeldeOptional = rebeldeService.comprarItem(id, item, quantidade);
        if(rebeldeOptional.isPresent()){
            return ResponseEntity.ok().body("Compra realizada com sucesso!");
        }else {
            return ResponseEntity.badRequest().body("Falha ao comprar.");
        }
    }

}
