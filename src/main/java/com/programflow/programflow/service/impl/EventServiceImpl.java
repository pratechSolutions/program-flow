package com.programflow.programflow.service.impl;
import com.programflow.programflow.dto.EventDto;
import com.programflow.programflow.dto.UserDto;
import com.programflow.programflow.dto.request.EventRequestDto;
import com.programflow.programflow.exception.ProgramFlowException;
import com.programflow.programflow.model.Event;
import com.programflow.programflow.model.User;
import com.programflow.programflow.repository.EventRepository;
import com.programflow.programflow.service.EventService;
import com.programflow.programflow.service.WebClientUserService;
import com.programflow.programflow.util.MapperUtils;

import java.util.UUID;

import static com.programflow.programflow.exception.ErrorType.*;


public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private WebClientUserService webClientUserService;
    private EventRequestDto eventRequestDto;


    public String addEvent(EventRequestDto eventRequestDto, String eventId) {
        UserDto userDto =
                webClientUserService.findByUserId(userId).orElseThrow(() -> new ProgramFlowException(USER_NOT_FOUND));

        if (!(userDto.getEventId() == null)) {
            throw new ProgramFlowException(USER_HAS_ALREADY_EVENT);
        }

        Event event = new Event();
        event.setEventName(eventRequestDto.getEventName());
        event.setPhoneNumber(eventRequestDto.getPhoneNumber());
        event.setAddressLine(eventRequestDto.getAddressLine());
        event.setEventDescription(eventRequestDto.getEventDescription());
        event.setCity(eventRequestDto.getCity());
        event.setPostalCode(eventRequestDto.getPostalCode());
        event.setCountry(eventRequestDto.getCountry());
        event.setEventStartDate(eventRequestDto.getEventStartDate());
        event.setEventEndDate(eventRequestDto.getEventEndDate());
        event.setEventLink(eventRequestDto.getEventLink());
        event.setEventId(UUID.randomUUID().toString());

        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserId(userId);
        event.setManagerUser(user);

        userDto.setPhoneNumber(eventRequestDto.getPhoneNumber());
        userDto.setEventId(event.getEventId());
        webClientUserService.updateUser(userDto, user.getUserId());

        return eventRepository.save(event).getCompanyId();
    }

    @Override
    public EventDto getEventByEventId(String eventId) {

        Event event =
                eventRepository.findEventByEventId(eventId).orElseThrow(() -> new ProgramFlowException(EVENT_NOT_FOUND);

        return MapperUtils.mapToEventDto(event);

    }

}