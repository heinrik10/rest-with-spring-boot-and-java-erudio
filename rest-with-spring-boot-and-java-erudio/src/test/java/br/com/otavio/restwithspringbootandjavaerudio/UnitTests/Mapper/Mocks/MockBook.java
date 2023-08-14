package br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper.Mocks;

import br.com.otavio.restwithspringbootandjavaerudio.Models.BookModel;
import br.com.otavio.restwithspringbootandjavaerudio.VO.BookVO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockBook {


    public BookModel mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<BookModel> mockEntityList() {
        List<BookModel> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    public BookModel mockEntity(Integer number) {
        BookModel book = new BookModel();
        book.setTitle("Title " + number);
        book.setPrice((long) (number * 20.2));
        book.setAuthor("Famous Author " + number);
        book.setId(number.longValue());
        book.setLaunch_date(LocalDateTime.of(2000, 03, 30, 05, 00));
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setTitle("Title " + number);
        book.setPrice((long) (number * 20.2));
        book.setAuthor("Famous Author " + number);
        book.setLaunch_date(LocalDateTime.of(2000, 03, 30, 05, 00));
        return book;
    }

}
