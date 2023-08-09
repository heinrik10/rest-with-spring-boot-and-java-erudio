package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Mapper.PersonMapper;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVO;
import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import br.com.otavio.restwithspringbootandjavaerudio.Exceptions.ResourceNotFoundException;
import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import br.com.otavio.restwithspringbootandjavaerudio.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public PersonVO findById(Long id){
        logger.info("Finding a new person");
        return PersonMapper.INSTANCE.personModelToPersonVO(personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));
    }

    public List<PersonVO> findByGender(Gender gender){
        logger.info("Finding a person");
        return PersonMapper.INSTANCE.listPersonModelToListPersonVO(personRepository.findPersonByGender(gender));
    }


    public List<PersonModel> findAll(){
        logger.info("Finding all people");
        return personRepository.findAll();
    }

    public PersonVO createNewPerson(PersonVO personVO) {
        logger.info("Creating a new person");

        var entity = PersonMapper.INSTANCE.personVOToPersonModel(personVO);

        return PersonMapper.INSTANCE.personModelToPersonVO(personRepository.save(entity));
    }

    public PersonVO updatePerson(Long id, PersonVO updatedPersonVO) {
        logger.info("Updating a person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(updatedPersonVO.getFirstName());
        person.setLastName(updatedPersonVO.getLastName());
        person.setAddress(updatedPersonVO.getAddress());
        person.setGender(updatedPersonVO.getGender());

        return PersonMapper.INSTANCE.personModelToPersonVO(personRepository.save(person));
    }

    public void deletePerson(Long id) {
        logger.info("Deleting a person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(person);
    }
}
