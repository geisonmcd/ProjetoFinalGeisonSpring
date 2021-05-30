package br.unisul.aula.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.unisul.aula.model.Pessoa;
import br.unisul.aula.model.Usuario;
import br.unisul.aula.repositorio.UsuarioRepositorio;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/todos")
    public List<Usuario> listarTodos(){
        return this.usuarioRepositorio.findAll();
    }

    @GetMapping("/buscar-id/{id}")
    public Usuario buscarPorId(@PathVariable(value = "id") Long id){
        return this.usuarioRepositorio.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado")
        );
    }

    @GetMapping("/buscar-nome/{nome}")
    public Usuario buscarPorNome(@PathVariable(value = "nome")String nome){
        return this.usuarioRepositorio.findPessoaByNome(nome);
    }

    @PostMapping("/adicionar")
    public Usuario inserirUsusario(@RequestBody Usuario usuario){
    	System.out.println("sexta o bahia joga");
    	System.out.println(usuario);
        return this.usuarioRepositorio.save(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> apagarPessoa(@PathVariable(value = "id")Long id){
        Usuario pessoa = buscarPorId(id);
        this.usuarioRepositorio.delete(pessoa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar/{id}")
    public Usuario alterarPessoa(@PathVariable(value = "id")Long id, @RequestBody Usuario novoUsuario){
        Usuario pessoaAntiga =this.buscarPorId(id);
        novoUsuario.setId(id);
        return this.usuarioRepositorio.save(novoUsuario);
    }
}
