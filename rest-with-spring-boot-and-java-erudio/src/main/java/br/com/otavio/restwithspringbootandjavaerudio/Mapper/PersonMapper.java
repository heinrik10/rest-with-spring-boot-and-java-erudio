package br.com.otavio.restwithspringbootandjavaerudio.Mapper;


import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVO personModelToPersonVO(PersonModel personModel);

    PersonModel personVOToPersonModel(PersonVO personVO);

    List<PersonVO> listPersonModelToListPersonVO(List<PersonModel> personModel);

    List<PersonModel> listPersonVOToListPersonModel(List<PersonVO> personVO);

}
