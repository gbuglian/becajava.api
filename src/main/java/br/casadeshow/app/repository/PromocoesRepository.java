package br.casadeshow.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casadeshow.app.model.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocoesRepository extends JpaRepository<Promocoes, Long> {

}
