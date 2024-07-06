package br.com.meuapp.HomeWealth.controller;

import br.com.meuapp.HomeWealth.model.Usuario;
import br.com.meuapp.HomeWealth.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Indica que esta classe é um controlador REST, capaz de lidar com requisições HTTP e retornar respostas JSON
@RestController

//Define o mapeamento base para todas as requisições lidando com usuários. Todas as URLs deste controlador começarão com '/api/usuarios'
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Mapeia requisições HTTP POST para o método register. A URL completa será /api/usuarios/register.
    @PostMapping("/register")

    //Método para registrar um novo usuário. Recebe um objeto Usuario no corpo da requisição (JSON) e retorna o objeto Usuario salvo.
    public Usuario registrar(@RequestBody Usuario usuario){
        //Chama o método saveUsuario do serviço UsuarioService para salvar o usuário e retorna o objeto Usuario salvo.
        return usuarioService.salvarUsuario(usuario);
    }

    //Mapeia requisições HTTP GET para o método getUsuarioByEmail. A URL completa será /api/usuarios/{email}.
    @PostMapping("/{email}")
    //Método para obter um usuário pelo email. Recebe o email como um parâmetro de caminho da URL e retorna o objeto Usuario encontrado
    public Usuario getFindByEmail(@PathVariable String email){
        //Chama o método findByEmail do serviço UsuarioService para encontrar o usuário pelo email e retorna o objeto Usuario encontrado.
        return usuarioService.findByEmail(email);
    }
}
