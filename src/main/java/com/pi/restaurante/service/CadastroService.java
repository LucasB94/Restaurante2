package com.pi.restaurante.service;

import com.pi.restaurante.exception.ResourceNotFoundException;
import com.pi.restaurante.modal.Cadastro;
import com.pi.restaurante.repository.CadastroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    
    @Autowired
    
    CadastroRepository cadastroRepository;
    
    public Cadastro criarCadastro (Cadastro c){
        
        c.setId(null);
        
        cadastroRepository.save(c);
        
        return c;
    }
    
    public Cadastro atualizarCadastro(Integer id, Cadastro cadastroRequest){
        
        Cadastro c = buscarCadastroPorId(id);
        
        c.setNome(cadastroRequest.getNome());
        c.setContato(cadastroRequest.getContato());
        c.setCpf(cadastroRequest.getCpf());
        c.setEmail(cadastroRequest.getEmail());
        
        cadastroRepository.save(c);
        
        return c;
    }
    
    public Cadastro buscarCadastroPorId(Integer cid){
        
        return cadastroRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado " + cid));
        
    }
    
    public List<Cadastro> listarTodosCadastros(){
        
        return cadastroRepository.findAll();
        
    }
    
    public void deletarCadastro(Integer cid){
        
        Cadastro c = buscarCadastroPorId(cid);
        cadastroRepository.deleteById(c.getId());
    }
}
