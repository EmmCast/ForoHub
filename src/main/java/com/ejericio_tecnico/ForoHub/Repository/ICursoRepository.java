package com.ejericio_tecnico.ForoHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejericio_tecnico.ForoHub.Entity.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long>{

}
