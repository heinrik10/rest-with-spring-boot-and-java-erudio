package br.com.otavio.restwithspringbootandjavaerudio.Repository.JpaRepository;

import br.com.otavio.restwithspringbootandjavaerudio.Models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookModel, Long> {
}
