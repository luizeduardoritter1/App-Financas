package br.com.meuapp.HomeWealth.repository;

import br.com.meuapp.HomeWealth.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
