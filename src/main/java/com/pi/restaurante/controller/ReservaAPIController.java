package com.pi.restaurante.controller;

import com.pi.restaurante.modal.Reserva;
import com.pi.restaurante.service.ReservaService;
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
@RequestMapping("/reserva")
public class ReservaAPIController {
    
    @Autowired
    
    ReservaService reservaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllReserva(){
        
        List<Reserva> reserva = reservaService.listarTodasReservas();
        return new ResponseEntity<>(reserva, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Integer id){
        
        Reserva reserva = reservaService.buscarReservaPorId(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva r){
        
        var novaReserva = reservaService.criarReserva(r);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable Integer id, @RequestBody Reserva r){
        
        var reservaAtualizado = reservaService.atualizarReserva(id, r);
        return new ResponseEntity<>(reservaAtualizado, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarReserva (@PathVariable Integer id){
        
        reservaService.deletarReserva(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
