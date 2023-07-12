package br.com.otavio.restwithspringbootandjavaerudio.Repository.JpaRepository;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<PersonModel, Long> {

    @Query("SELECT p from PersonModel p WHERE p.gender = :gender")
    List<PersonModel> findPersonByGender(@Param("gender") Gender gender);
}
