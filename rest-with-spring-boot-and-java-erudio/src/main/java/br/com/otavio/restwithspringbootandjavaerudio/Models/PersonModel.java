package br.com.otavio.restwithspringbootandjavaerudio.Models;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Person")
public class PersonModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 6)
    private Gender gender;

    @Column(nullable = false, length = 50)
    private String address;
}
