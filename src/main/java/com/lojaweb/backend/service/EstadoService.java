package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lojaweb.backend.domain.Estado;
import com.lojaweb.backend.repository.EstadoRepository;
import jakarta.validation.Valid;

@Service
public class EstadoService {

     @Autowired
    private  EstadoRepository estadoRepository;

    public List<Estado> listarTodos(){
        return estadoRepository.findAll();
    }

    public ResponseEntity<Estado> salvaEstado(@RequestBody @Valid Estado estado){
        estado.setDataCriaçao(new Date());
        Estado novoEstado =  estadoRepository.save(estado);
        return new ResponseEntity<>(novoEstado, HttpStatus.CREATED);
    }

    public ResponseEntity<Estado> alterarEstado(@RequestBody @Valid Estado estado){
        estado.setDataAtualizacao(new Date());
        return new ResponseEntity<>(estadoRepository.save(estado), HttpStatus.OK);
    }

   public void deletaEstado(Long id){
        Estado idEstado = estadoRepository.findById(id).get();
        estadoRepository.delete(idEstado);
    }

    

}
