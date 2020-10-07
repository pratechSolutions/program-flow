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

import java.util.UUID;

import static com.programflow.programflow.exception.ErrorType.USER_HAS_ALREADY_COMPANY;
import static com.programflow.programflow.exception.ErrorType.USER_NOT_FOUND;


public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final WebClientUserService webClientUserService;
    private final EventRequestDto eventRequestDto;


    public String addEvent(EventDto eventDTO, String eventId) {
        UserDto userDto =
                webClientUserService.findByUserId(userId).orElseThrow(() -> new ProgramFlowException(USER_NOT_FOUND));

        if (!(userDto.getEventId() == null)) {
            throw new ProgramFlowException(USER_HAS_ALREADY_COMPANY);
        }

        Event event = new Event();
        event.setAddressLine(eventRequestDto.getAddressLine());
        event.setPostalCode(eventRequestDto.getPostalCode());
        event.setCountry(eventRequestDto.getCountry());
        event.setEventId(UUID.randomUUID().toString());
        event.setEventName(userDto.getEventName());

        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserId(userId);
        user.setPhoneNumber(eventRequestDto.getPhoneNumber());
        event.setManagerUser(user);

        userDto.setPhoneNumber(eventRequestDto.getPhoneNumber());
        userDto.setEventId(event.getEventId());
        webClientUserService.updateUser(userDto, user.getUserId());

        return eventRepository.save(event).getCompanyId();
    }
}
