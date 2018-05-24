package hr.hackaton.codebandits.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    public Person() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String userName;

    @Column
    private int password;

    @Column
    private String birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column
    @OneToMany
    private List<DonatingLocation> donatingLocations;

    @Column
    private Integer noOfDonations = 0;

    @Column
    @OneToMany
    private List<Institution> institutions;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public List<DonatingLocation> getDonatingLocations() {
        return donatingLocations;
    }

    public void setDonatingLocations(List<DonatingLocation> donatingLocations) {
        this.donatingLocations = donatingLocations;
    }

    public Integer getNoOfDonations() {
        return noOfDonations;
    }

    public void setNoOfDonations(Integer noOfDonations) {
        this.noOfDonations = noOfDonations;
    }

    public List<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

}
