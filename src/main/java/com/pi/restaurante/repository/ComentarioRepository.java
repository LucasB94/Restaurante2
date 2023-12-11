package com.pi.restaurante.repository;

import com.pi.restaurante.modal.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> { 

}
