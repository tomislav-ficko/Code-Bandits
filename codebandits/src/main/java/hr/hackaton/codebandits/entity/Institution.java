package hr.hackaton.codebandits.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Institution {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne
    private Location institutionLocation;

    @Column
    @OneToMany
    private List<Person> institutionPersons;

    public String getName() {
        return name;
    }

    public Location getInstitutionLocation() {
        return institutionLocation;
    }

    public List<Person> getInstitutionPersons() {
        return institutionPersons;
    }

    public void setInstitutionPersons(List<Person> institutionPersons) {
        this.institutionPersons = institutionPersons;
    }

    public Institution(String name, Location institutionLocation, List<Person> institutionPersons) {
        this.name = name;
        this.institutionLocation = institutionLocation;
        this.institutionPersons = institutionPersons;
    }
}
