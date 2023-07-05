package br.com.otavio.restwithspringbootandjavaerudio.Repository;

import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
