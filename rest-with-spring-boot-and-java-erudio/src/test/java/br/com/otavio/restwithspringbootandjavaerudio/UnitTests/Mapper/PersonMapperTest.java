package br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import br.com.otavio.restwithspringbootandjavaerudio.Mapper.PersonMapper;
import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import br.com.otavio.restwithspringbootandjavaerudio.UnitTests.Mapper.Mocks.MockPerson;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PersonMapperTest {
    
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = PersonMapper.INSTANCE.personModelToPersonVO(inputObject.mockEntity());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals(Gender.M, output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = PersonMapper.INSTANCE.listPersonModelToListPersonVO(inputObject.mockEntityList());

        PersonVO outputZero = outputList.get(0);
        
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals(Gender.M, outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals(Gender.F, outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals(Gender.M, outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        PersonModel output = PersonMapper.INSTANCE.personVOToPersonModel(inputObject.mockVO());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals(Gender.M, output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<PersonModel> outputList = PersonMapper.INSTANCE.listPersonVOToListPersonModel(inputObject.mockVOList());

        PersonModel outputZero = outputList.get(0);
        
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals(Gender.M, outputZero.getGender());
        
        PersonModel outputSeven = outputList.get(7);
        
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals(Gender.F, outputSeven.getGender());
        
        PersonModel outputTwelve = outputList.get(12);
        
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals(Gender.M, outputTwelve.getGender());
    }
}
