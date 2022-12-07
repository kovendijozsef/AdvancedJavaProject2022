package org.ppke.itk.formula1.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // INDENTITY
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String nationality;
    private String imagePath;



    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    @JsonIgnore
    private List<Driver> drivers;

}
