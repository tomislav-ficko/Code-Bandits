package hr.hackaton.codebandits.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private int password;
}
