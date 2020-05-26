package com.example.examen.dao;

import com.example.examen.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
public class LibroDAOImpl implements LibroDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
        List<Libro> resultset = query.getResultList();

        return resultset;
    }

    @Override
    @Transactional
    public void insert(Libro libro) throws DataAccessException {
        Date fecha_ingreso = new Date();
        libro.setFechaIngreso(fecha_ingreso);
        libro.setCategoria(categoriaDAO.findOne(libro.getCodigoCategoria()));
        entityManager.persist(libro);
    }
}
