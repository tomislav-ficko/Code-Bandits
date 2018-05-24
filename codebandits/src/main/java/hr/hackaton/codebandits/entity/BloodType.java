package hr.hackaton.codebandits.entity;

public enum BloodType {
    A_plus("A_plus"),
    A_minus("A_minus"),
    B_plus("B_plus"),
    B_minus("B_minus"),
    AB_plus("AB_plus"),
    AB_minus("AB_minus"),
    O_plus("O_plus"),
    O_minus("O_minus");

    private String type;

    private BloodType(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
