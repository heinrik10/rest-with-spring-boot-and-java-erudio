package br.com.otavio.restwithspringbootandjavaerudio.VO;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class PersonVOv2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
    private Date birthDay;
}
