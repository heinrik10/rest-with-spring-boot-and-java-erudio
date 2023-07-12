package br.com.otavio.restwithspringbootandjavaerudio.VO;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import lombok.Data;

@Data
public class PersonVO {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
}
