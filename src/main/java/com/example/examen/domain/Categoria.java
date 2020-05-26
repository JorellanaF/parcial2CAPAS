package com.example.examen.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {

    @Id
    @GeneratedValue(generator = "cat_categoria_c_categoria_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_categoria")
    public Integer codigoCategoria;

    @Column(name = "s_categoria")
    @Size(message = "El campo sobrepasa la cantidad de 50 caracteres", max = 50)
    @NotEmpty(message = "El campo nombre categoría no puede estar vacío")
    public String categoria;

    public Categoria() {
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
