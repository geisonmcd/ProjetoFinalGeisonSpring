package br.unisul.aula.controlador;

import br.unisul.aula.model.Pessoa;
import br.unisul.aula.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    @GetMapping("/todos")
    public List<Pessoa> listarTodos(){
        return this.pessoaRepositorio.findAll();
    }

    @GetMapping("/buscar-id/{id}")
    public Pessoa buscarPorId(@PathVariable(value = "id") Long id){
        return this.pessoaRepositorio.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado")
        );
    }

    @GetMapping("/buscar-nome/{nome}")
    public Pessoa buscarPorNome(@PathVariable(value = "nome")String nome){
        return this.pessoaRepositorio.findPessoaByNome(nome);
    }

    @PostMapping("/adicionar")
    public Pessoa inserirPessoa(@RequestBody Pessoa pessoa){
        return this.pessoaRepositorio.save(pessoa);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Pessoa> apagarPessoa(@PathVariable(value = "id")Long id){
        Pessoa pessoa = buscarPorId(id);
        this.pessoaRepositorio.delete(pessoa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar/{id}")
    public Pessoa alterarPessoa(@PathVariable(value = "id")Long id, @RequestBody Pessoa pessoaNovo){
        Pessoa pessoaAntiga =this.buscarPorId(id);
        pessoaNovo.setId(id);
        return this.pessoaRepositorio.save(pessoaNovo);
    }
}
