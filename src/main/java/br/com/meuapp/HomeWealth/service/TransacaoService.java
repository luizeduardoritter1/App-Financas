package br.com.meuapp.HomeWealth.service;

import br.com.meuapp.HomeWealth.model.Transacao;
import br.com.meuapp.HomeWealth.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    // Método para obter transações pelo ID do usuário
    public List<Transacao> getTransacaoById(Long usuarioId){

        // Busca as transações no repositório pelo ID do usuário e retorna a lista de transações
        return transacaoRepository.findByUsuarioId(usuarioId);
    }

    // Método para salvar uma transação
    public Transacao salvarTransacao(Transacao transacao){

        // Salva a transação no repositório e retorna a transação salva
        return transacaoRepository.save(transacao);
    }

    // Método para deletar uma transação pelo Id
    public void deletarTransacao(Long id){

        // Deleta a transação do repositório pelo ID
        transacaoRepository.deleteById(id);
    }
}
