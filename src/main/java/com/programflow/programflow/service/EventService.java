package com.programflow.programflow.service;

import com.programflow.programflow.dto.request.EventRequestDto;

public interface EventService {

    String addEvent(EventRequestDto eventRequestDto, String userId);
}
