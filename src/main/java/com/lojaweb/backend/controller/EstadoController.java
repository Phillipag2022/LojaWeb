package com.lojaweb.backend.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lojaweb.backend.domain.Estado;
import com.lojaweb.backend.service.EstadoService;

@RestController
@RequestMapping("api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;


    @GetMapping("/")
    //@CrossOrigin("http://localhost:3000")
    public List<Estado> listarTodos(){
        return estadoService.listarTodos();
    }

    @PostMapping("/")
    //@CrossOrigin("http://localhost:3000")
    public ResponseEntity<Estado> insertEstado(@RequestBody Estado estado){
        return estadoService.salvaEstado(estado);
        
    }
    @PutMapping("/")
   // @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Estado> updateEstado(@RequestBody Estado estado){
        return estadoService.alterarEstado(estado);
    }
    @DeleteMapping("/{id}")
    //@CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluiEstado(@PathVariable("id")Long id){
        estadoService.deletaEstado(id);
        return ResponseEntity.ok().build();

    }


    

   
}