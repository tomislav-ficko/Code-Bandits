package hr.hackaton.codebandits.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public List<DonationLocation> getDonationLocations() {
        return donationLocations;
    }

    public void setDonationLocations(List<DonationLocation> donationLocations) {
        this.donationLocations = donationLocations;
    }

    public Integer getNoOfDonations() {
        return noOfDonations;
    }

    public void setNoOfDonations(Integer noOfDonations) {
        this.noOfDonations = noOfDonations;
    }

    public User(String name, String surname, String email, String phoneNumber, String userName, int password, Date birthDate, Sex sex, BloodType bloodType, List<DonationLocation> donationLocations, Integer noOfDonations) {

        super(name, surname, email, phoneNumber, userName, password);
        this.birthDate = birthDate;
        this.sex = sex;
        this.bloodType = bloodType;
        this.donationLocations = donationLocations;
        this.noOfDonations = noOfDonations;
    }
}
