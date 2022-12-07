package org.ppke.itk.formula1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Event;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Integer id;
    private String raceName;
    private String country;
    private LocalDate date;


    public static EventDto fromEvent(Event event) {

        return new EventDto(
                event.getId(),
                event.getRaceName(),
                event.getCountry(),
                event.getDate()
        );
    }
}
