package org.ppke.itk.formula1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.formula1.domain.Circuit;
import org.ppke.itk.formula1.domain.Driver;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CircuitDto {

    private Integer id;
    private String name;
    private String country;
    private String length;
    private String lapRecord;
    private String imagePath;
    private Driver lapRecordHolder;

    public static CircuitDto fromCircuit(Circuit circuit){
        return new CircuitDto(
                circuit.getId(),
                circuit.getName(),
                circuit.getCountry(),
                circuit.getLength(),
                circuit.getLapRecord(),
                circuit.getImagePath(),
                circuit.getLapRecordHolder()
        );
    }
}
