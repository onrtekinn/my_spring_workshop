package com.otekin.controller;

import com.otekin.dto.PersonDto;
import com.otekin.services.PersonServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final PersonServices personServices;


    @PostMapping
    public ResponseEntity<PersonDto> add(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personServices.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> ListofAll() {
        return ResponseEntity.ok(personServices.getAll());
    }
}

