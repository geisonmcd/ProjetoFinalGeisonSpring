package br.unisul.aula.controlador;

import br.unisul.aula.dto.ProjetoDTO;
import br.unisul.aula.model.Projeto;
import br.unisul.aula.repositorio.ProjetoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    ProjetoRepositorio projetoRepositorio;

    @GetMapping("/todos")
    public List<ProjetoDTO> listarTodos(){
        List<ProjetoDTO> projetoDTOS = new ArrayList<>();
        for (Projeto projeto: projetoRepositorio.findAll()){
            ProjetoDTO projetoDTO = new ProjetoDTO(projeto);
            projetoDTOS.add(projetoDTO);
        }
        return projetoDTOS;
    }

    @PostMapping("/adicionar")
    public void adicionarProjeto(@RequestBody ProjetoDTO projetoDTO) throws ParseException {
        Projeto projeto = new Projeto();
        projeto.setNome(projetoDTO.getNome());
        projeto.setDataPrevistaInicio(projetoDTO.getDataPrevistaInicio());
        projeto.setDataPrevistaFim(projetoDTO.getDataPrevistaFim());
        this.projetoRepositorio.save(projeto);
    }
}
