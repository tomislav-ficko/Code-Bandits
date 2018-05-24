package hr.hackaton.codebandits.entity;

public enum Sex {
    M("M"), F("F");

    private String letter;

    private Sex(String letter){
        this.letter = letter;
    }

    public void setLetter(String letter){
        this.letter = letter;
    }
}
