package hr.hackaton.codebandits.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
public class Institution {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Location location;

    @Column
    private List<User> users;
}
