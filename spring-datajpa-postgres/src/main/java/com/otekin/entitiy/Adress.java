package com.otekin.entitiy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Person_Adresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name ="seq_person_adress",allocationSize = 1)
    @GeneratedValue (generator = "seq_person_adress",strategy = GenerationType.SEQUENCE)

    private Long id;
    @Column(length=500,name = "adress")
    private String adress;
    @Enumerated
    private AdressType adressType;
    @Column(name ="IsActive")
    private boolean IsActive;
    @ManyToOne
    @JoinColumn(name="person_adresses_id")
    private Employee employee;


    public enum AdressType{
        home,
        work,
        etc
    }
}
