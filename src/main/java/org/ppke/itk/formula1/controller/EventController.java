package org.ppke.itk.formula1.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.formula1.controller.dto.DriverDto;
import org.ppke.itk.formula1.controller.dto.EventDto;
import org.ppke.itk.formula1.controller.dto.TeamDto;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Event;
import org.ppke.itk.formula1.domain.Team;
import org.ppke.itk.formula1.repository.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    private final EventService eventService;
    @GetMapping("{eventId}")
    public EventDto getEvent(@PathVariable Integer eventId){
        return EventDto.fromEvent(eventService.getEvent(eventId));
    }


    @GetMapping
    public List<EventDto> getEvents(Pageable pageable){

        Page<Event> events = eventService.findAll(pageable);
        Page<EventDto> eventsDto = new PageImpl<>(events.stream().map(EventDto::fromEvent).toList(), pageable, events.getTotalElements());

        return eventsDto.toList();

//        List<Event> events = eventService.findAll();
//        List<EventDto> eventsDto = new ArrayList<>();
//        for (Event event : events){
//            eventsDto.add(EventDto.fromEvent(event));
//        }
//        return eventsDto;
    }

}
