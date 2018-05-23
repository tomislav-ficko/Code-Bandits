package hr.hackaton.codebandits.controller;

import hr.hackaton.codebandits.boundary.PersonRepository;
import hr.hackaton.codebandits.entity.BloodType;
import hr.hackaton.codebandits.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class RegistrationController {
    @Autowired
    private PersonRepository personRepository;




}
