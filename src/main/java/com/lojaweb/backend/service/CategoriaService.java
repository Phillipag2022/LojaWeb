package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lojaweb.backend.domain.Categoria;
import com.lojaweb.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listaTodos(){
        return categoriaRepository.findAll();
    }

    public ResponseEntity<Categoria> salvaCategoria(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return new ResponseEntity<Categoria>(novaCategoria, HttpStatus.CREATED);
    }

    public ResponseEntity<Categoria> alteraCategoria(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return new ResponseEntity<>(categoriaRepository.save(categoria), HttpStatus.OK);
    }

    public void deletaCategoria(Long id){
         Categoria idCategoria = this.categoriaRepository.findById(id).get();
        categoriaRepository.delete(idCategoria);
    }
}
