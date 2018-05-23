package hr.hackaton.codebandits.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class DonationLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Location location;

    @Column
    private List<Person> donators;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Person> getDonators() {
        return donators;
    }

    public void setDonators(List<Person> donators) {
        this.donators = donators;
    }

    public DonationLocation(Location location, List<Person> donators) {

        this.location = location;
        this.donators = donators;
    }
}
