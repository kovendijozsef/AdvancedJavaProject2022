package org.ppke.itk.formula1.repository;

import org.ppke.itk.formula1.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
