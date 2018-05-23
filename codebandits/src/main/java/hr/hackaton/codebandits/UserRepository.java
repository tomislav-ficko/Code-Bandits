package hr.hackaton.codebandits;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findBySurname(String title);

    List<User> findByBloodType(BloodType bloodType);

    List<User> findByLocation(String inputLocationParams);
}
