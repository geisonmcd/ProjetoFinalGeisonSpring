package br.unisul.aula.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pessoas")
@SequenceGenerator(name = "seq_pessoas", allocationSize = 1)
public class Pessoa {

    @Id
    @Column(name = "id_pessoas")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoas")
    private long id;
    @Column(name = "nm_pessoas")
    private String nome;
    @Column(name = "nm_cargo")
    private String cargo;

    public Pessoa(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public Pessoa() {
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
