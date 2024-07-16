package com.ejericio_tecnico.ForoHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ejericio_tecnico.ForoHub.Dto.CrearUsuario;
import com.ejericio_tecnico.ForoHub.Entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	UserDetails findByEmail(String email);

}
