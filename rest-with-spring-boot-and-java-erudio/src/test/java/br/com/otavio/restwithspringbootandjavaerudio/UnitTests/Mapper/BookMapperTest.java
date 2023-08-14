package br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper;

import br.com.otavio.restwithspringbootandjavaerudio.Mapper.BookMapper;
import br.com.otavio.restwithspringbootandjavaerudio.Models.BookModel;
import br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper.Mocks.MockBook;
import br.com.otavio.restwithspringbootandjavaerudio.VO.BookVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookMapperTest {

    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = BookMapper.INSTANCE.bookModelToBookVO(inputObject.mockEntity());
        validateBookMapperVO(output, 0L);
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = BookMapper.INSTANCE.listBookModelToListBookVO(inputObject.mockEntityList());

        BookVO outputZero = outputList.get(0);
        validateBookMapperVO(outputZero, 0L);

        BookVO outputSeven = outputList.get(7);
        validateBookMapperVO(outputSeven, 7L);

        BookVO outputTwelve = outputList.get(12);
        validateBookMapperVO(outputTwelve, 12L);

    }

    @Test
    public void parseVOToEntityTest() {
        BookModel output = BookMapper.INSTANCE.bookVOToBookModel(inputObject.mockVO());
        validateBookMapperModel(output, 0L);
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<BookModel> outputList = BookMapper.INSTANCE.listBookVOToListBookModel(inputObject.mockVOList());

        BookModel outputZero = outputList.get(0);
        validateBookMapperModel(outputZero, 0L);

        BookModel outputSeven = outputList.get(7);
        validateBookMapperModel(outputSeven, 7L);


        BookModel outputTwelve = outputList.get(12);
        validateBookMapperModel(outputTwelve, 12L);
    }

    private void validateBookMapperVO(BookVO output, Long number) {
        assertEquals((long) (number * 20.2), output.getPrice());
        assertEquals("Title " + number, output.getTitle());
        assertEquals(LocalDateTime.of(2000, 03, 30, 05, 00), output.getLaunch_date());
        assertEquals("Famous Author " + number, output.getAuthor());
    }

    private void validateBookMapperModel(BookModel output, Long number) {
        assertEquals((long) (number * 20.2), output.getPrice());
        assertEquals("Title " + number, output.getTitle());
        assertEquals(LocalDateTime.of(2000, 03, 30, 05, 00), output.getLaunch_date());
        assertEquals("Famous Author " + number, output.getAuthor());
    }
}
