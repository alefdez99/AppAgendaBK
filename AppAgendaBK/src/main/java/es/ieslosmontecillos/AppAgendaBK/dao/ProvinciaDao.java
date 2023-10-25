package es.ieslosmontecillos.AppAgendaBK.dao;

import es.ieslosmontecillos.AppAgendaBK.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProvinciaDao extends JpaRepository<Provincia, Long> {
}
