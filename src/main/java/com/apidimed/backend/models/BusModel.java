package com.apidimed.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "busTable")
public class BusModel implements Serializable {

    @Id
    private Long id;

    @Column
    private String codigo;

    @Column
    private String nome;

    public BusModel() {
    }

    public BusModel(Long id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "BusModel{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusModel)) return false;
        BusModel busModel = (BusModel) o;
        return Objects.equals(getId(), busModel.getId()) &&
                Objects.equals(getCodigo(), busModel.getCodigo()) &&
                Objects.equals(getNome(), busModel.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo(), getNome());
    }
}
