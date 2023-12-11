package com.pi.restaurante.repository;

import com.pi.restaurante.modal.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> { 

}
