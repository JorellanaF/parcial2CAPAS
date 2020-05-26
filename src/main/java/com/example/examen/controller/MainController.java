package com.example.examen.controller;

import com.example.examen.dao.CategoriaDAO;
import com.example.examen.dao.LibroDAO;
import com.example.examen.domain.Categoria;
import com.example.examen.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private LibroDAO libroDAO;

    @Autowired
    private CategoriaDAO categoriaDAO;

    @RequestMapping("/index")
    public ModelAndView init(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/addLibro")
    public ModelAndView addLibro(){
        ModelAndView mav = new ModelAndView();
        List<Categoria> categorias = null;

        try {
            categorias=categoriaDAO.findAll();
        }catch(Exception e) {
            e.printStackTrace();
        }

        mav.addObject("libro", new Libro());
        mav.addObject("categorias", categorias);
        mav.setViewName("agregarLibro");

        return mav;
    }

    @RequestMapping("/addCategoria")
    public ModelAndView addCategoria(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("categoria", new Categoria());
        mav.setViewName("agregarCategoria");

        return mav;
    }

    @RequestMapping("/libros")
    public ModelAndView libros(){
        ModelAndView mav = new ModelAndView();

        List<Libro> libros = null;
        List<Categoria> categorias = null;
        try {
            libros = libroDAO.findAll();
            categorias=categoriaDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("libros", libros);
        mav.addObject("categorias", categorias);
        mav.setViewName("libros");

        return mav;
    }

    @RequestMapping("/validarL")
    public ModelAndView formL(@Valid @ModelAttribute Libro libro, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            List<Categoria> categorias = null;

            try {
                categorias=categoriaDAO.findAll();
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("categorias", categorias);
            mav.setViewName("agregarLibro");
        }else {
            try {
                libroDAO.insert(libro);
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("exitoL", "Libro guardado con éxito");
            mav.setViewName("index");
        }

        return mav;
    }

    @RequestMapping("/validarC")
    public ModelAndView formC(@Valid @ModelAttribute Categoria categoria, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            mav.setViewName("agregarCategoria");
        }else {
            try {
                categoriaDAO.insert(categoria);
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("exitoC", "Categoria guardada con éxito");
            mav.setViewName("index");
        }

        return mav;
    }
}
