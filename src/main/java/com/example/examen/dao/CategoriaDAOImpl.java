package com.example.examen.dao;

import com.example.examen.domain.Categoria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CategoriaDAOImpl implements CategoriaDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
        List<Categoria> resultset = query.getResultList();

        return resultset;
    }

    @Override
    public Categoria findOne(Integer codigoCategoria) throws DataAccessException {
        Categoria categoria = entityManager.find(Categoria.class, codigoCategoria);

        return categoria;
    }

    @Override
    @Transactional
    public void insert(Categoria categoria) throws DataAccessException {
        entityManager.persist(categoria);
    }
}
