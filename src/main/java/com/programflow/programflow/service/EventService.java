package com.programflow.programflow.service;

import com.programflow.programflow.dto.EventDto;

public interface EventService {

    String addEvent(EventDto eventDTO, String userId);
}
