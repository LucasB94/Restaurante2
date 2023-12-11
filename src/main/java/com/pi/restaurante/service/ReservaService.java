package com.pi.restaurante.service;

import com.pi.restaurante.exception.ResourceNotFoundException;
import com.pi.restaurante.modal.Reserva;
import com.pi.restaurante.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    
    @Autowired
    
    ReservaRepository reservaRepository;
    
    public Reserva criarReserva(Reserva r){
        
        r.setId(null);
        
        reservaRepository.save(r);
        
        return r;
    }
    
    public Reserva atualizarReserva(Integer id, Reserva reservaRequest){
        
        Reserva r = buscarReservaPorId(id);
        
        r.setNome(reservaRequest.getNome());
        r.setContato(reservaRequest.getContato());
        r.setEmail(reservaRequest.getEmail());
        
        reservaRepository.save(r);
        
        return r;
    }
    
    public Reserva buscarReservaPorId(Integer rid){
        
        return reservaRepository.findById(rid).orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrado " + rid));
        
    }
    
    public List<Reserva> listarTodasReservas(){
        
        return reservaRepository.findAll();
        
    }
    
    public void deletarReserva(Integer rid){
        
        Reserva r = buscarReservaPorId(rid);
        reservaRepository.deleteById(r.getId());
    }
}
