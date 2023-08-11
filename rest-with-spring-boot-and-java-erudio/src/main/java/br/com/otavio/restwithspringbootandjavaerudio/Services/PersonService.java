package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Controller.PersonController;
import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import br.com.otavio.restwithspringbootandjavaerudio.Exceptions.ResourceNotFoundException;
import br.com.otavio.restwithspringbootandjavaerudio.Mapper.PersonMapper;
import br.com.otavio.restwithspringbootandjavaerudio.Repository.PersonRepository;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public PersonVO findById(Long id) {
        logger.info("Finding a new person");
        var vo = PersonMapper.INSTANCE.personModelToPersonVO(personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<PersonVO> findByGender(Gender gender) {
        logger.info("Finding a person");

        var vo = PersonMapper.INSTANCE.listPersonModelToListPersonVO(personRepository.findPersonByGender(gender));

        vo.forEach(x -> x.add(linkTo(methodOn(PersonController.class).findByGender(gender)).withSelfRel()));
        return vo;
    }


    public List<PersonVO> findAll() {
        logger.info("Finding all people");
        var vo = PersonMapper.INSTANCE.listPersonModelToListPersonVO(personRepository.findAll());
        vo.forEach(x -> x.add(linkTo(methodOn(PersonController.class).findAll()).withSelfRel()));
        return vo;
    }

    public PersonVO createNewPerson(PersonVO personVO) {
        logger.info("Creating a new person");
        var entity = PersonMapper.INSTANCE.personVOToPersonModel(personVO);
        var vo = PersonMapper.INSTANCE.personModelToPersonVO(personRepository.save(entity));
        vo.add(linkTo(methodOn(PersonController.class).createNewPerson(personVO)).withSelfRel());
        return vo;
    }

    public PersonVO updatePerson(Long id, PersonVO updatedPersonVO) {
        logger.info("Updating a person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(updatedPersonVO.getFirstName());
        person.setLastName(updatedPersonVO.getLastName());
        person.setAddress(updatedPersonVO.getAddress());
        person.setGender(updatedPersonVO.getGender());

        var vo = PersonMapper.INSTANCE.personModelToPersonVO(personRepository.save(person));
        vo.add(linkTo(methodOn(PersonController.class).updatePerson(id, updatedPersonVO)).withSelfRel());
        return vo;
    }

    public void deletePerson(Long id) {
        logger.info("Deleting a person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(person);
    }
}
