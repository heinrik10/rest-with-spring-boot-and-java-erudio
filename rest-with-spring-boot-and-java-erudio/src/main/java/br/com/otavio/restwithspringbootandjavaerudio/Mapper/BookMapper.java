package br.com.otavio.restwithspringbootandjavaerudio.Mapper;

import br.com.otavio.restwithspringbootandjavaerudio.Models.BookModel;
import br.com.otavio.restwithspringbootandjavaerudio.VO.BookVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookVO bookModelToBookVO(BookModel model);

    BookModel bookVOToBookModel(BookVO vo);

    List<BookVO> listBookModelToListBookVO(List<BookModel> listModel);

    List<BookModel> listBookVOToListBookModel(List<BookVO> listVO);
}
