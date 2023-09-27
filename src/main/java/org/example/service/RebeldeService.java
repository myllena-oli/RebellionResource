package org.example.service;

import org.example.model.BaseDeCompras;
import org.example.model.Inventario;
import org.example.model.Rebelde;
import org.example.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebeldeService {

    @Autowired
    private RebeldeRepository rebeldeRepository;
    private BaseDeCompras baseDeCompras = new BaseDeCompras();

    public Rebelde adicionarRebelde(Rebelde rebelde) {
        return rebeldeRepository.save(rebelde);
    }

    public List<Rebelde> listarRebeldes() {
        return rebeldeRepository.findAll();
    }

    public Rebelde atualizarLocalizacao(Long rebeldeId, String novaLocalizacao) {
        Rebelde rebelde = rebeldeRepository.findById(rebeldeId).orElse(null);
        if (rebelde != null) {
            rebelde.setLocalizacao(novaLocalizacao);
            return rebeldeRepository.save(rebelde);
        }
        return null;
    }

    public Rebelde reportarTraidor(Long rebeldeId) {
        Rebelde rebelde = rebeldeRepository.findById(rebeldeId).orElse(null);

        if (rebelde != null) {
            rebelde.setDenuncias(rebelde.getDenuncias() + 1);
            if (rebelde.getDenuncias() >= 3) {
                rebelde.setTraidor(true);
            }
            return rebeldeRepository.save(rebelde);
        }
        return null;
    }


    public double calcularPorcentagemTraidores() {
        List<Rebelde> rebeldes = listarRebeldes();
        if (rebeldes.isEmpty()) {
            return 0.0;
        }

        long traidores = rebeldes.stream().filter(Rebelde::isTraidor).count();
        return (double) traidores / rebeldes.size() * 100.0;

    }

    public double calcularPorcentagemRebeldes() {
        List<Rebelde> rebeldes = listarRebeldes();
        if (rebeldes.isEmpty()) {
            return 0.0;
        }

        long rebeldesNaoTraidores = rebeldes.stream().filter(p -> !p.isTraidor()).count();
        return (double) rebeldesNaoTraidores / rebeldes.size() * 100.0;
    }

    public Rebelde comprarItem(Long rebeldeId, String item, int quantidade) {
        Rebelde rebelde = rebeldeRepository.findById(rebeldeId).orElse(null);
        if (rebelde != null && !rebelde.isTraidor()) {
            double preco = baseDeCompras.getPrecoItem(item);
            if (preco == 0.0) {
                return null;
            }
            double valorTotal = preco * quantidade;

            if(rebelde.getCarteira() >= valorTotal){
                rebelde.setCarteira(rebelde.getCarteira() - valorTotal);

                List<Inventario> inventario = rebelde.getInventario();
                Inventario recurso = inventario.stream()
                        .filter(r -> r.getNome().equals(item))
                        .findFirst()
                        .orElse(null);
                if (recurso != null){
                    recurso.setQuantidade(recurso.getQuantidade()+ quantidade);
                } else{
                    Inventario inventario1 = new Inventario();
                    inventario1.setNome(item);
                    inventario1.setQuantidade(quantidade);
                    inventario.add(inventario1);
                }
                return rebeldeRepository.save(rebelde);
            }

        }

        return null;
    }

}
