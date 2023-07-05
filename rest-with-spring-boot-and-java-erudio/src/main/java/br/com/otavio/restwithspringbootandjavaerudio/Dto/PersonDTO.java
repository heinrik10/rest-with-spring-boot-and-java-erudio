package br.com.otavio.restwithspringbootandjavaerudio.Dto;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import lombok.Data;

@Data
public class PersonDTO {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
}
