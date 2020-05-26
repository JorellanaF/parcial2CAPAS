package com.example.examen.dao;

import com.example.examen.domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroDAO {
    List<Libro> findAll() throws DataAccessException;
    void insert(Libro libro) throws DataAccessException;
}
