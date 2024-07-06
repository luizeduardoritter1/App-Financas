package br.com.meuapp.HomeWealth.service;

import br.com.meuapp.HomeWealth.model.Usuario;
import br.com.meuapp.HomeWealth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Anotação @Service indica que esta classe é um serviço Spring, um componente de negócios
@Service
public class UsuarioService {

    // Anotação @Autowired indica que o Spring deve injetar a dependência automaticamente
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Método público para salvar um usuário. Recebe um objeto Usuario como parâmetro.
    public Usuario salvarUsuario(Usuario usuario) {
        //Codifica a senha do usuário usando BCryptPasswordEncoder antes de salvar no banco de dados.
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    // Método para encontrar um usuário pelo email
    public Usuario findByEmail(String email){

        // Busca o usuário no repositório pelo email e retorna o usuário encontrado
        return usuarioRepository.findByEmail(email);
    }
}
