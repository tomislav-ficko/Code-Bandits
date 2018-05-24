package hr.hackaton.codebandits.controller;

import com.clearspring.analytics.util.Lists;
import hr.hackaton.codebandits.boundary.PersonRepository;
import hr.hackaton.codebandits.entity.BloodType;
import hr.hackaton.codebandits.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/users")
    public List<Person> getAllUsers() {
        return Lists.newArrayList(personRepository.findAll());
    }

    @GetMapping("/users/{userName}")
    public Person findByUserName(@PathVariable String userName) {
        return personRepository.findByUserName(userName);
    }

    @GetMapping("/users/{surname}")
    public List<Person> findBySurname(@PathVariable String surname) {
        return personRepository.findBySurname(surname);
    }

    @GetMapping("/users/{bloodType}")
    public List<Person> findByBloodType(@PathVariable BloodType bloodType) {
        return personRepository.findByBloodType(bloodType);
    }

    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Person person) {
        Person existingPerson = personRepository.findByUserName(person.getUserName());
        if (null == existingPerson) {
            personRepository.save(person);
            return true;
        }
        return false;
    }

    @DeleteMapping("/users/{userName}")
    public boolean delete(@PathVariable String userName) {
        Person person = personRepository.findByUserName(userName);
        if (person != null) {
            personRepository.delete(person);
            return true;
        }
        return false;
    }

//    @PutMapping("/{id}")
//    public Person updateUser(@RequestBody Person user, @PathVariable Long id) {
//        if (user.getId() != id) {
//            throw new Person()IdMismatchException();
//        }
//        personRepository.findOne(id)
//                .orElseThrow(UserNotFoundException::new);
//        return personRepository.save(user);
//    }
}
