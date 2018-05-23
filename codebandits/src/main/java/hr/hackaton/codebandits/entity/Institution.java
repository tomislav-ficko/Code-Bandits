package hr.hackaton.codebandits.entity;

import java.util.List;

public class Institution {
    private String name;
    private Location institutionLocation;
    private List<User> institutionUsers;

    public String getName() {
        return name;
    }

    public Location getInstitutionLocation() {
        return institutionLocation;
    }

    public List<User> getInstitutionUsers() {
        return institutionUsers;
    }

    public void setInstitutionUsers(List<User> institutionUsers) {
        this.institutionUsers = institutionUsers;
    }

    public Institution(String name, Location institutionLocation, List<User> institutionUsers) {
        this.name = name;
        this.institutionLocation = institutionLocation;
        this.institutionUsers = institutionUsers;
    }
}
