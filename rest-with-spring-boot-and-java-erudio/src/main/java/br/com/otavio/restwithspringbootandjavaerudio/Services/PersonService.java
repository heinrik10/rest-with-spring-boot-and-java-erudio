package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Mapper.DozerMapper;
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
        return DozerMapper.parseObject(personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonVO.class);
    }

    public List<PersonVO> findByGender(Gender gender){
        logger.info("Finding a new person");
        return DozerMapper.parseListObject(personRepository.findPersonByGender(gender), PersonVO.class);
    }


    public List<PersonModel> findAll(){
        logger.info("Finding all the people");
        return personRepository.findAll();
    }

    public PersonVO createNewPerson(PersonVO personVO) {
        logger.info("Creating a new person");

        var entity = DozerMapper.parseObject(personVO, PersonModel.class);

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO updatePerson(Long id, PersonVO updatedPersonVO) {
        logger.info("Updating a new person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(updatedPersonVO.getFirstName());
        person.setLastName(updatedPersonVO.getLastName());
        person.setAddress(updatedPersonVO.getAddress());
        person.setGender(updatedPersonVO.getGender());

        return DozerMapper.parseObject(personRepository.save(person), PersonVO.class);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting a new person");
        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(person);
    }
}
