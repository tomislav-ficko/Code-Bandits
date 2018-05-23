package hr.hackaton.codebandits.entity;

import java.util.List;

public class Admin extends Person {
    private List<Institution> institutions;

    public List<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

    public Admin(String name, String surname, String email, String phoneNumber, String userName, int password, List<Institution> institutions) {

        super(name, surname, email, phoneNumber, userName, password);
        this.institutions = institutions;
    }
}
