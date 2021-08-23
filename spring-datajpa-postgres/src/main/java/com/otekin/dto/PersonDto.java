package com.otekin.dto;

import com.otekin.entitiy.Adress;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data

public class PersonDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<String> adresses;
}
