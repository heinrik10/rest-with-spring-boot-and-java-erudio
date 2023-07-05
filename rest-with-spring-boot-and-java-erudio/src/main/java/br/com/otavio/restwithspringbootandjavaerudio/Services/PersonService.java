package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Dto.PersonDTO;
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


    public PersonModel findById(Long id){
        logger.info("Finding a new person");
        return personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<PersonModel> findAll(){
        logger.info("Finding all the people");
        return personRepository.findAll();
    }

    public PersonModel createNewPerson(PersonDTO personDTO) {
        logger.info("Creating a new person");

        PersonModel personModel = new PersonModel();
        personModel.setFirstName(personDTO.getFirstName());
        personModel.setLastName(personDTO.getLastName());
        personModel.setGender(personDTO.getGender());
        personModel.setAddress(personDTO.getAddress());

        return personRepository.save(personModel);
    }

    public PersonModel updatePerson(Long id, PersonDTO updatedPersonDTO) {
        logger.info("Updating a new person");
        var person = findById(id);
        person.setFirstName(updatedPersonDTO.getFirstName());
        person.setLastName(updatedPersonDTO.getLastName());
        person.setAddress(updatedPersonDTO.getAddress());
        person.setGender(updatedPersonDTO.getGender());

        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting a new person");
        var person = findById(id);
        personRepository.delete(person);
    }
}
