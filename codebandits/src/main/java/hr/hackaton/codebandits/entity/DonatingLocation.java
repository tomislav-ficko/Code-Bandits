package hr.hackaton.codebandits.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DonatingLocation {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Location location;

    @Column
    @OneToMany
    private List<Person> donators;

    public Location getLocation() {
        return location;
    }

    public List<Person> getDonators() {
        return donators;
    }

    public void setDonators(List<Person> donators) {
        this.donators = donators;
    }

    public DonatingLocation(Location location, List<Person> donators) {
        this.location = location;
        this.donators = donators;
    }
}
