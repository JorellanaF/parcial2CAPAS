package com.example.examen.dao;

import com.example.examen.domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaDAO {
    List<Categoria> findAll() throws DataAccessException;
    Categoria findOne(Integer codigoCategoria) throws DataAccessException;
    void insert(Categoria categoria) throws DataAccessException;
}
