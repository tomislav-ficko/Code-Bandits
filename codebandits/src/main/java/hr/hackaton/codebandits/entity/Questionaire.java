package hr.hackaton.codebandits.entity;

import java.util.Map;

public class Questionaire {
    Map<String, Boolean> questions;

    public Map<String, Boolean> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Boolean> questions) {
        this.questions = questions;
    }

    public Questionaire(Map<String, Boolean> questions) {

        this.questions = questions;
    }
}
