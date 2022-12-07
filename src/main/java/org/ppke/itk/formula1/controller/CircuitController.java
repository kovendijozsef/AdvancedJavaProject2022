package org.ppke.itk.formula1.controller;

import lombok.AllArgsConstructor;
import org.ppke.itk.formula1.controller.dto.CircuitDto;
import org.ppke.itk.formula1.domain.Circuit;
import org.ppke.itk.formula1.repository.CircuitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/circuits")
@CrossOrigin(origins = "http://localhost:4200")
public class CircuitController {

    private CircuitService circuitService;

    @GetMapping("{circuitId}")
    public CircuitDto getCircuit(@PathVariable Integer circuitId){
        return CircuitDto.fromCircuit(circuitService.getCircuit(circuitId));
    }

    @GetMapping
    public List<CircuitDto> getCircuits(){
        List<Circuit> circuits = circuitService.findAll();
        List<CircuitDto> circuitsDto = circuits.stream().map(CircuitDto::fromCircuit).toList();
        return circuitsDto;
    }
}
