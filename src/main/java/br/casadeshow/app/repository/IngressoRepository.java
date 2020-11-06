package br.casadeshow.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casadeshow.app.model.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

}
