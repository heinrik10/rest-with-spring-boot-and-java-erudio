package br.com.otavio.restwithspringbootandjavaerudio.Controller;

import br.com.otavio.restwithspringbootandjavaerudio.Services.BookService;
import br.com.otavio.restwithspringbootandjavaerudio.VO.BookVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.otavio.restwithspringbootandjavaerudio.Util.MediaType.APPLICATION_YAML;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Books", description = "Endpoints for Managing Books")
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService) {this.bookService = bookService;}

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML})
    public ResponseEntity<BookVO> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML})
    public ResponseEntity<List<BookVO>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @DeleteMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML})
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML})
    public ResponseEntity<BookVO> createBook(@RequestBody BookVO book) {
        return ResponseEntity.ok(bookService.create(book));
    }

    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML})
    public ResponseEntity<BookVO> updateBook(@RequestBody BookVO book, @PathVariable Long id) {
        return ResponseEntity.ok(bookService.update(book, id));
    }
}
