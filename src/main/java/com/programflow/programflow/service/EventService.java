package com.programflow.programflow.service;

import com.programflow.programflow.dto.EventDto;
import com.programflow.programflow.dto.request.EventRequestDto;

public interface EventService {

    String addEvent(EventRequestDto eventRequestDto, String userId);

    EventDto getEventByEventId(String eventId);
}
