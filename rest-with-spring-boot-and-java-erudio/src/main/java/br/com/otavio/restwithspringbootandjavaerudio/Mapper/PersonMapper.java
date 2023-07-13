package br.com.otavio.restwithspringbootandjavaerudio.Mapper;


import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVOv1;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVOv1 personModelToPersonVO(PersonModel personModel);

    PersonModel personVOToPersonModel(PersonVOv1 personVOv1);

    List<PersonVOv1> listPersonModelToListPersonVO(List<PersonModel> personModel);

    List<PersonModel> listPersonVOToListPersonModel(List<PersonVOv1> personVOv1);

}
