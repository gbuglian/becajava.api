package br.casadeshow.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.casadeshow.app.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
