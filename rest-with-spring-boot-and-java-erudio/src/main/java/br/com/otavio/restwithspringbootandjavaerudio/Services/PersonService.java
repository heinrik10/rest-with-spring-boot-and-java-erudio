package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Mapper.PersonMapper;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVOv1;
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


    public PersonVOv1 findById(Long id){
        logger.info("Finding a new person");
        return PersonMapper.INSTANCE.personModelToPersonVO(personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));
    }

    public List<PersonVOv1> findByGender(Gender gender){
        logger.info("Finding a person");
        return PersonMapper.INSTANCE.listPersonModelToListPersonVO(personRepository.findPersonByGender(gender));
    }


    public List<PersonModel> findAll(){
        logger.info("Finding all people");
        return personRepository.findAll();
    }

    public PersonVOv1 createNewPerson(PersonVOv1 personVOv1) {
        logger.info("Creating a new person");

        var entity = PersonMapper.INSTANCE.personVOToPersonModel(personVOv1);

        return PersonMapper.INSTANCE.personModelToPersonVO(personRepository.save(entity));
    }

    public PersonVOv1 updatePerson(Long id, PersonVOv1 updatedPersonVOv1) {
        logger.info("Updating a person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(updatedPersonVOv1.getFirstName());
        person.setLastName(updatedPersonVOv1.getLastName());
        person.setAddress(updatedPersonVOv1.getAddress());
        person.setGender(updatedPersonVOv1.getGender());

        return PersonMapper.INSTANCE.personModelToPersonVO(personRepository.save(person));
    }

    public void deletePerson(Long id) {
        logger.info("Deleting a person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(person);
    }
}
