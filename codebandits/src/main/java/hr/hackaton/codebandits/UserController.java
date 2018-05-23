package hr.hackaton.codebandits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{surname}")
    public List<User> findBySurname(@PathVariable String surname) {
        return userRepository.findBySurname(surname);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userRepository.findOne(id).orElseThrow(UserNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.findOne(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new User()IdMismatchException();
        }
        userRepository.findOne(id)
                .orElseThrow(UserNotFoundException::new);
        return userRepository.save(user);
    }
}
