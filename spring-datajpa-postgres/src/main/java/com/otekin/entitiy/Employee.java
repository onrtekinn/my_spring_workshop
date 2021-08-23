package com.otekin.entitiy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(name ="seq_person",allocationSize = 1)
    @GeneratedValue(generator = "seq_person",strategy = GenerationType.SEQUENCE)

    private Long id;
    @Column(length=100,name = "firstname")
    private String firstname;
    @Column(length=100,name = "lastname")
    private String lastname;
    @OneToMany
    @JoinColumn(name = "person_adresses_id")
    private List<Adress> adressesList;
}
