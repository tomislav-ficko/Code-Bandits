package hr.hackaton.codebandits.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
public class Admin extends Person {
    @Column
    private List<Institution> institutions;
}
