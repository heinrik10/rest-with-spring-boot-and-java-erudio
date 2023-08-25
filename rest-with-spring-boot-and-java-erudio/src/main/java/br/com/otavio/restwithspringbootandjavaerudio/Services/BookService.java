package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Controller.BookController;
import br.com.otavio.restwithspringbootandjavaerudio.Exceptions.ResourceNotFoundException;
import br.com.otavio.restwithspringbootandjavaerudio.Mapper.BookMapper;
import br.com.otavio.restwithspringbootandjavaerudio.Repository.BookRepository;
import br.com.otavio.restwithspringbootandjavaerudio.VO.BookVO;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookVO findById(Long id){
        var vo = BookMapper.INSTANCE.bookModelToBookVO(bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records Found for this ID")));
        return vo.add(linkTo(methodOn(BookController.class).findBookById(id)).withSelfRel());
    }

    public List<BookVO> findAll(){
        var vo = BookMapper.INSTANCE.listBookModelToListBookVO(bookRepository.findAll());
        vo.forEach(x -> x.add(linkTo(methodOn(BookController.class).findAllBooks()).withSelfRel()));
        return vo;
    }

    public void delete(Long id){
        var book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records Found for this ID"));
        bookRepository.delete(book);
    }

    public BookVO create(BookVO bookVO){
        var bookModel = BookMapper.INSTANCE.bookVOToBookModel(bookVO);
        var vo = BookMapper.INSTANCE.bookModelToBookVO(bookRepository.save(bookModel));
        return vo.add(linkTo(methodOn(BookController.class).createBook(bookVO)).withSelfRel());
    }

    public BookVO update(BookVO bookVO, Long id){
        var bookModel = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records Found for this ID"));

        bookModel.setAuthor(bookVO.getAuthor());
        bookModel.setTitle(bookVO.getTitle());
        bookModel.setPrice(bookVO.getPrice());
        bookModel.setLaunch_date(bookVO.getLaunch_date());

        var vo = BookMapper.INSTANCE.bookModelToBookVO(bookRepository.save(bookModel));
        return vo.add(linkTo(methodOn(BookController.class).updateBook(bookVO, id)).withSelfRel());
    }
}
