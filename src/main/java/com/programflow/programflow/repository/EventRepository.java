package com.programflow.programflow.repository;

import com.programflow.programflow.model.Event;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository {

    Optional<Event> findEventByEventId(String eventId);


}
