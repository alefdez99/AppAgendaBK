package es.ieslosmontecillos.AppAgendaBK.Dao;

import es.ieslosmontecillos.AppAgendaBK.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
}