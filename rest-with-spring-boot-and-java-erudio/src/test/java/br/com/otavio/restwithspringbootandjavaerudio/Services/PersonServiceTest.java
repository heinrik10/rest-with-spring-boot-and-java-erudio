package br.com.otavio.restwithspringbootandjavaerudio.Services;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import br.com.otavio.restwithspringbootandjavaerudio.Exceptions.ResourceNotFoundException;
import br.com.otavio.restwithspringbootandjavaerudio.Mapper.PersonMapper;
import br.com.otavio.restwithspringbootandjavaerudio.Repository.PersonRepository;
import br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper.Mocks.MockPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    MockPerson input;

    @InjectMocks
    private PersonService service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUoMocks() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(PersonServiceTest.class);
    }

    @Test
    void findById() {
        var person = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        var response = service.findById(1L);

        assertEquals(person.getAddress(), response.getAddress());
        assertEquals(person.getFirstName(), response.getFirstName());
        assertEquals(person.getLastName(), response.getLastName());
        assertEquals(person.getGender(), response.getGender());
    }

    @Test
    void findByGender() {
        var person = input.mockEntity(1);
        person.setGender(Gender.M);
        when(repository.findPersonByGender(Gender.M)).thenReturn(List.of(person));

        var response = service.findByGender(Gender.M);

        assertFalse(response.isEmpty());
        for (var p : response) {
            assertEquals(person.getAddress(), p.getAddress());
            assertEquals(person.getFirstName(), p.getFirstName());
            assertEquals(person.getLastName(), p.getLastName());
            assertEquals(person.getGender(), p.getGender());
        }

    }

    @Test
    void findAll() {
        var person = input.mockEntity(1);
        person.setGender(Gender.M);
        when(repository.findAll()).thenReturn(List.of(person));

        var response = service.findAll();

        assertFalse(response.isEmpty());
        for (var p : response) {
            assertEquals(person.getAddress(), p.getAddress());
            assertEquals(person.getFirstName(), p.getFirstName());
            assertEquals(person.getLastName(), p.getLastName());
            assertEquals(person.getGender(), p.getGender());
        }
    }

    @Test
    void createNewPerson() {
        var person = input.mockEntity(1);
        person.setId(null); //necessário pois a aplicação cria um id
        when(repository.save(person)).thenReturn(person);
        var vo = PersonMapper.INSTANCE.personModelToPersonVO(person);
        var response = service.createNewPerson(vo);

        assertEquals(vo.getAddress(), response.getAddress());
        assertEquals(vo.getFirstName(), response.getFirstName());
        assertEquals(vo.getLastName(), response.getLastName());
        assertEquals(vo.getGender(), response.getGender());
    }

    @Test
    void updatePersonOk() {
        var person = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        when(repository.save(person)).thenReturn(person);
        var vo = PersonMapper.INSTANCE.personModelToPersonVO(person);
        var response = service.updatePerson(person.getId(), vo);

        assertEquals(vo.getAddress(), response.getAddress());
        assertEquals(vo.getFirstName(), response.getFirstName());
        assertEquals(vo.getLastName(), response.getLastName());
        assertEquals(vo.getGender(), response.getGender());
    }

    @Test
    void updatePersonNotFound() {
        var person = input.mockEntity(1);
        when(repository.findById(1L)).thenThrow(new ResourceNotFoundException("No records found for this ID"));
        var vo = PersonMapper.INSTANCE.personModelToPersonVO(person);

        var response = Assertions.assertThrows(ResourceNotFoundException.class, () -> service.updatePerson(person.getId(), vo));
        assertSame("No records found for this ID", response.getMessage());
    }

    @Test
    void deletePerson() {
        var person = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        doNothing().when(repository).delete(person);
        service.deletePerson(1L);
    }
}