package com.ejericio_tecnico.ForoHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejericio_tecnico.ForoHub.Entity.Topico;

@Repository
public interface ITopicoRepository extends JpaRepository<Topico, Long>{

}
