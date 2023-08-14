package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Mapper.BookMapper;
import br.com.otavio.restwithspringbootandjavaerudio.Models.BookModel;
import br.com.otavio.restwithspringbootandjavaerudio.Repository.BookRepository;
import br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper.Mocks.MockBook;
import br.com.otavio.restwithspringbootandjavaerudio.VO.BookVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    MockBook input;

    @InjectMocks
    private BookService service;

    @Mock
    private BookRepository repository;

    @BeforeEach
    void setUoMocks() {
        input = new MockBook();
        MockitoAnnotations.openMocks(BookServiceTest.class);
    }

    @Test
    void findById() {
        var book = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(book));
        var response = service.findById(1L);
        validateBookModel(book, response);
    }

    @Test
    void findAll() {
        var book = input.mockEntity(1);
        when(repository.findAll()).thenReturn(List.of(book));

        var response = service.findAll();

        assertFalse(response.isEmpty());
        for (var p : response) {
            validateBookModel(book, p);
        }

    }

    @Test
    void delete() {
        var book = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(book));
        doNothing().when(repository).delete(book);
        service.delete(1L);
    }

    @Test
    void create() {
        var book = input.mockEntity(1);
        book.setId(null); //necessário pois a aplicação cria um id para a pessoa
        when(repository.save(book)).thenReturn(book);
        var vo = BookMapper.INSTANCE.bookModelToBookVO(book);
        var response = service.create(vo);

        validateBookModel(book, response);
    }

    private void validateBookModel(BookModel model, BookVO response) {
        assertEquals(model.getPrice(), response.getPrice());
        assertEquals(model.getTitle(), response.getTitle());
        assertEquals(model.getLaunch_date(), response.getLaunch_date());
        assertEquals(model.getAuthor(), response.getAuthor());
    }

    @Test
    void update() {
        var book = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(book));
        when(repository.save(book)).thenReturn(book);
        var vo = BookMapper.INSTANCE.bookModelToBookVO(book);

        var response = service.update(vo, book.getId());
        validateBookModel(book, response);

    }
}