package com.pi.restaurante.controller;

import com.pi.restaurante.modal.Comentario;
import com.pi.restaurante.service.ComentarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentario")
public class ComentarioAPIController {
    
    @Autowired
    
    ComentarioService comentarioService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllComentario(){
        
        List<Comentario> comentario = comentarioService.listarTodosComentarios();
        return new ResponseEntity<>(comentario, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Comentario> buscarComentarioPorId(@PathVariable Integer id){
        
        Comentario comentario = comentarioService.buscarComentarioPorId(id);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<Comentario> addComentario(@Valid @RequestBody Comentario com){
        
        var novoComentario = comentarioService.criarComentario(com);
        return new ResponseEntity<>(novoComentario, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Comentario> atualizarComentario(@PathVariable Integer id, @RequestBody Comentario com){
        
        var comentarioAtualizado = comentarioService.atualizarComentario(id, com);
        return new ResponseEntity<>(comentarioAtualizado, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletarComentario (@PathVariable Integer id){
        
        comentarioService.deletarComentario(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
}
