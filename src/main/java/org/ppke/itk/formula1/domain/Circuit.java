package org.ppke.itk.formula1.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String country;
    private String length;
    private String lapRecord;
    private String imagePath;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "circuit")
    private Driver lapRecordHolder;
}
