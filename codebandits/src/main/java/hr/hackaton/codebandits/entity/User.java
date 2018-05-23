package hr.hackaton.codebandits.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User extends Person {
    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private Sex sex;

    @Column(nullable = false)
    private BloodType bloodType;

    @Column(nullable = false)
    private List<DonationLocation> donationLocations;

    @Column
    private Integer noOfDonations = 0;
}
