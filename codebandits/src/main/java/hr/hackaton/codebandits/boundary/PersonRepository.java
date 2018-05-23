package hr.hackaton.codebandits.boundary;

import hr.hackaton.codebandits.entity.BloodType;
import hr.hackaton.codebandits.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findBySurname(String title);

    List<Person> findByBloodType(BloodType bloodType);

    List<Person> findByLocation(String inputLocationParams);

    Person findByUserName(String userName);
}
