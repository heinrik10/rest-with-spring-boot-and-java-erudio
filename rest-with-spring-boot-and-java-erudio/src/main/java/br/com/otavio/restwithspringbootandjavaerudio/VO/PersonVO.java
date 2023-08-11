package br.com.otavio.restwithspringbootandjavaerudio.VO;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
}
