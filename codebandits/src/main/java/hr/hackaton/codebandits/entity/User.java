package hr.hackaton.codebandits.entity;

import java.util.Date;
import java.util.List;

public class User extends Person {
    private Date birthDate;
    private Sex sex;
    private BloodType bloodType;
    private List<DonatingLocation> donatingLocations;
    private Integer noOfDonations = 0;

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

    public User(String name, String surname, String email, String phoneNumber, String userName, int password, Date birthDate, Sex sex, BloodType bloodType, List<DonatingLocation> donatingLocations, Integer noOfDonations) {

        super(name, surname, email, phoneNumber, userName, password);
        this.birthDate = birthDate;
        this.sex = sex;
        this.bloodType = bloodType;
        this.donatingLocations = donatingLocations;
        this.noOfDonations = noOfDonations;
    }
}
