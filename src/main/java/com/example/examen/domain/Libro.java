package com.example.examen.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;

    @Transient
    private Integer codigoCategoria;

    @Id
    @GeneratedValue(generator = "cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_libro")
    private Integer codigoLibro;

    @Column(name = "s_titulo")
    @Size(message = "El campo sobrepasa la cantidad de 500 caracteres", max = 500)
    @NotEmpty(message = "El campo no puede estar vacío")
    private String titulo;

    @Column(name = "s_autor")
    @Size(message = "El campo sobrepasa la cantidad de 150 caracteres", max = 150)
    @NotEmpty(message = "El campo no puede estar vacío")
    private String autor;

    @Column(name = "f_ingreso")
    @DateTimeFormat(pattern=" dd/mm/yyyy hh:mm")
    private Date fechaIngreso;

    @Column(name = "b_estado")
    private Boolean estado;

    @Column(name = "s_isbn")
    @Size(message = "El campo sobrepasa la cantidad de 10 caracteres", max = 10)
    @NotEmpty(message = "El campo no puede estar vacío")
    private String isbn;

    public Libro() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String delegateEstado(){
        return estado ? "Disponible":"Agotado";
    }
}
