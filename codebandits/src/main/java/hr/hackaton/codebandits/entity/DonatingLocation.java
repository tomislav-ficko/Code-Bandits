package hr.hackaton.codebandits.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DonatingLocation {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Location location;

    @Column
    @OneToMany
    private List<User> donators;

    public Location getLocation() {
        return location;
    }

    public List<User> getDonators() {
        return donators;
    }

    public void setDonators(List<User> donators) {
        this.donators = donators;
    }

    public DonatingLocation(Location location, List<User> donators) {
        this.location = location;
        this.donators = donators;
    }
}
