package hr.hackaton.codebandits.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
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
    private Date birthDate;

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

    public Date getBirthDate() {
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

    public Person(String name, String surname, String email, String phoneNumber, String userName, int password, Date birthDate, Sex sex, BloodType bloodType, List<DonatingLocation> donatingLocations, Integer noOfDonations) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.sex = sex;
        this.bloodType = bloodType;
        this.donatingLocations = donatingLocations;
        this.noOfDonations = noOfDonations;
    }

    public Person(String name, String surname, String email, String phoneNumber, String userName, int password, List<Institution> institutions) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.institutions = institutions;
    }
}
