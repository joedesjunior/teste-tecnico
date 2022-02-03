package com.apidimed.backend.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BusDTO implements Serializable {

    @XmlElement
    private String id;

    @XmlElement
    private String codigo;

    @XmlElement
    private String nome;

    public BusDTO() {
    }

    public BusDTO(String id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusDTO)) return false;
        BusDTO busDTO = (BusDTO) o;
        return Objects.equals(getId(), busDTO.getId()) &&
                Objects.equals(getCodigo(), busDTO.getCodigo()) &&
                Objects.equals(getNome(), busDTO.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo(), getNome());
    }

    @Override
    public String toString() {
        return "BusDTO{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
