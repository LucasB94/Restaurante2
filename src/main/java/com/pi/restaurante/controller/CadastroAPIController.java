package com.pi.restaurante.controller;

import com.pi.restaurante.modal.Cadastro;
import com.pi.restaurante.service.CadastroService;
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
@RequestMapping("/cadastro")
public class CadastroAPIController {
    
    @Autowired
    
    CadastroService cadastroService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllCadastro(){
        
        List<Cadastro> cadastro = cadastroService.listarTodosCadastros();
        return new ResponseEntity<>(cadastro, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Cadastro> buscarCadastroPorId(@PathVariable Integer id){
        
        Cadastro cadastro = cadastroService.buscarCadastroPorId(id);
        return new ResponseEntity<>(cadastro, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<Cadastro> addCadastro(@Valid @RequestBody Cadastro c){
        
        var novoCadastro = cadastroService.criarCadastro(c);
        return new ResponseEntity<>(novoCadastro, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cadastro> atualizarCadastro(@PathVariable Integer id, @RequestBody Cadastro c){
        
        var cadastroAtualizado = cadastroService.atualizarCadastro(id, c);
        return new ResponseEntity<>(cadastroAtualizado, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCadastro (@PathVariable Integer id){
        
        cadastroService.deletarCadastro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
