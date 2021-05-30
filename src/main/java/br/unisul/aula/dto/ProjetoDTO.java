package br.unisul.aula.dto;

import br.unisul.aula.model.Projeto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjetoDTO {
    private long id;
    private String nome;
    private String dataPrevistaInicio;
    private String dataPrevistaFim;

    public ProjetoDTO(long id, String nome, Date dataPrevistaInicio, Date dataPrevistaFim) {
        this.id = id;
        this.nome = nome;
        this.dataPrevistaInicio = converData(dataPrevistaInicio);
        this.dataPrevistaFim = converData(dataPrevistaFim);
    }

    public ProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.dataPrevistaInicio = converData(projeto.getDataPrevistaInicio());
        this.dataPrevistaFim = converData(projeto.getDataPrevistaFim());
    }

    private String converData(Date data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataPrevistaInicio() {
        return dataPrevistaInicio;
    }

    public void setDataPrevistaInicio(String dataPrevistaInicio) {
        this.dataPrevistaInicio = dataPrevistaInicio;
    }

    public String getDataPrevistaFim() {
        return dataPrevistaFim;
    }

    public void setDataPrevistaFim(String dataPrevistaFim) {
        this.dataPrevistaFim = dataPrevistaFim;
    }
}
