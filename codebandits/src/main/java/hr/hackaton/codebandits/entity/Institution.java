package hr.hackaton.codebandits.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Location location;

    @Column
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Institution(String name, Location location, List<User> users) {

        this.name = name;
        this.location = location;
        this.users = users;
    }
}
