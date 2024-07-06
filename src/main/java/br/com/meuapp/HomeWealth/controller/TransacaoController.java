package br.com.meuapp.HomeWealth.controller;


import br.com.meuapp.HomeWealth.model.Transacao;
import br.com.meuapp.HomeWealth.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")

public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    public List<Transacao> getTransacaoUsuarioId(@PathVariable Long usuarioId){
        return transacaoService.getTransacaoById(usuarioId);
    }

    @PostMapping
    public Transacao salvarTransacao(@RequestBody Transacao transacao){
        return transacaoService.salvarTransacao(transacao);
    }

    //Mapeia requisições HTTP DELETE para o método deleteTransacao. A URL completa será /api/transacoes/{id}.
    @DeleteMapping({"/{id}"})
    public void deletarTransacao(@PathVariable Long id) {
        transacaoService.deletarTransacao(id);
    }
}
