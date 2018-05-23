package hr.hackaton.codebandits.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class DonatingLocation {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Location location;

    @Column

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
