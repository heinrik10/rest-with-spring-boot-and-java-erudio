package br.com.otavio.restwithspringbootandjavaerudio.Controller;

import br.com.otavio.restwithspringbootandjavaerudio.Enum.Gender;
import br.com.otavio.restwithspringbootandjavaerudio.Models.PersonModel;
import br.com.otavio.restwithspringbootandjavaerudio.Services.PersonService;
import br.com.otavio.restwithspringbootandjavaerudio.VO.PersonVOv1;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOv1> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping(value = "/gender",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonVOv1>> findByGender(@RequestParam Gender gender) {
        return ResponseEntity.ok(personService.findByGender(gender));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonModel>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PersonVOv1> createNewPerson(@RequestBody PersonVOv1 personVOv1) {
        return ResponseEntity.ok(personService.createNewPerson(personVOv1));
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOv1> updatePerson(@PathVariable Long id, @RequestBody PersonVOv1 personVOv1) {
        return ResponseEntity.ok(personService.updatePerson(id, personVOv1));
    }

    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}
