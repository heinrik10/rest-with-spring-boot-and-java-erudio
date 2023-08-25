package br.com.otavio.restwithspringbootandjavaerudio.Repository;

import br.com.otavio.restwithspringbootandjavaerudio.Repository.JpaRepository.BookJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BookJpaRepository {
}
