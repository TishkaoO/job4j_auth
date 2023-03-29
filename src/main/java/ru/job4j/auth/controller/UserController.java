package ru.job4j.auth.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ru.job4j.auth.domain.Person;
import ru.job4j.auth.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final PersonService personService;
    private final BCryptPasswordEncoder encoder;

    @PostMapping("/sign-up")
    public Person signUp(@RequestBody Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
      return personService.save(person);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return personService.getAll();
    }
}