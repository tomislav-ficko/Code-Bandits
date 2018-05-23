package hr.hackaton.codebandits.controller;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        if (null == personRepository.findByUserName(person.getUserName())) {
            return personRepository.save(person);
        }
        return null;
    }

    @DeleteMapping("/{userName}")
    public void delete(@PathVariable String userName) {
        Person person = personRepository.findByUserName(userName);
        if (person != null) {
            personRepository.delete(person);
        }

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
