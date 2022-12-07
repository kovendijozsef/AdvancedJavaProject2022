package org.ppke.itk.formula1.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "driver")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;
    private String name;
    @Transient
    private Integer age;
    private Integer points;
    private LocalDate dataOfBirth;
    private String racingNumber;
    private String imagePath;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "circuit_id")
    private Circuit circuit;

    // String name eddig nem volt valamiert
    public Driver(Integer id, String name,Integer points, LocalDate dataOfBirth, String racingNumber, String imagePath) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.dataOfBirth = dataOfBirth;
        this.racingNumber = racingNumber;
        this.imagePath = imagePath;
        this.team = null;

    }

    public Integer getAge() {
        return Period.between(this.dataOfBirth, LocalDate.now()).getYears();
    }


}
