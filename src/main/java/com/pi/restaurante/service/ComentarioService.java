package com.pi.restaurante.service;

import com.pi.restaurante.exception.ResourceNotFoundException;
import com.pi.restaurante.modal.Comentario;
import com.pi.restaurante.repository.ComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired

    ComentarioRepository comentarioRepository;

    public Comentario criarComentario(Comentario com) {

        com.setId(null);

        comentarioRepository.save(com);

        return com;
    }

    public Comentario atualizarComentario(Integer id, Comentario comentarioRequest){
        
        Comentario com = buscarComentarioPorId(id);
        
        com.setAnalise(comentarioRequest.getAnalise());
        
        comentarioRepository.save(com);
        
        return com;
    }
    
    public Comentario buscarComentarioPorId(Integer comid){
        
        return comentarioRepository.findById(comid).orElseThrow(() -> new ResourceNotFoundException("Comentario não encontrado " + comid));
        
    }
    
    public List<Comentario> listarTodosComentarios(){
        
        return comentarioRepository.findAll();
        
    }
    
    public void deletarComentario(Integer comid){
        Comentario com = buscarComentarioPorId(comid);
        comentarioRepository.deleteById(com.getId());
    }
}
