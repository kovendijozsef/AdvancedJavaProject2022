package org.ppke.itk.formula1.repository;

import org.ppke.itk.formula1.controller.dto.CircuitDto;
import org.ppke.itk.formula1.domain.Circuit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitService {

    private CircuitRepository circuitRepository;

    @Autowired
    public CircuitService(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    public Circuit getCircuit(Integer circuitId) {
        return circuitRepository.findById(circuitId).get();
    }

    public List<Circuit> findAll() {
        return circuitRepository.findAll();
    }
}
