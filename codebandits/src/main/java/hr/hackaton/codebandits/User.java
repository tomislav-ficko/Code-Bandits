package hr.hackaton.codebandits;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)//, unique = false/true
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private Sex sex;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private BloodType bloodType;

    @Column(nullable = false)
    private Location location;

    @Column
    private Integer noOfDonations = 0;
}
