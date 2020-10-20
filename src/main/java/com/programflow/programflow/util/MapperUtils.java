package com.programflow.programflow.util;

import com.programflow.programflow.dto.EventDto;
import com.programflow.programflow.dto.UserDto;
import com.programflow.programflow.dto.request.EventRequestDto;
import com.programflow.programflow.model.Event;

import java.util.stream.Collectors;

public class MapperUtils {


    public static EventDto mapToEventDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setEventDescription("Address Line :" + event.getEventDescription() + ", " + event.getCity() + ", " + event.getCountry().toString() + ", " + event.getPostalCode());
        eventDto.setEventStartDate(event.getEventStartDate());
        eventDto.setEventEndDate(event.getEventEndDate());
        eventDto.setEventLink(event.getEventLink());

        return eventDto;
    }

    public static EventRequestDto mapToEventRequestDto(Event event) {
        EventRequestDto eventRequestDto = new EventRequestDto();
        eventRequestDto.setEventName(event.getEventName());
        eventRequestDto.setPhoneNumber(event.getPhoneNumber());
        eventRequestDto.setAddressLine(event.getAddressLine());

        return eventRequestDto;
    }

//    public static UserDto convertToUserDto(Event event) {
//        UserDto userDto = new UserDto();
//        userDto.setFullName(user);
//        userDto.setBuyerType(company.getManagerUser().getBuyerType());
//        userDto.setUserType(company.getManagerUser().getUserType());
//        userDto.setApplicationDate(company.getRegistrationDate());
//        userDto.setDocuments(company.getDocuments().stream().map(document -> MapperUtils.mapToDocumentDto(document)).collect(Collectors.toList()));
//        return userDto;
//    }
//
//    public static ApplicationListDto convertToApplicationListDto(Company company) {
//        ApplicationListDto applicationListDto = new ApplicationListDto();
//        applicationListDto.setApplicationDateTime(company.getRegistrationDate());
//        applicationListDto.setApplicationId(company.getCompanyId());
//        applicationListDto.setFullName(company.getManagerUser().getFullName());
//        applicationListDto.setUserType(company.getManagerUser().getUserType());
//        applicationListDto.setCompanyName(company.getCompanyName());
//        return applicationListDto;
//    }
//
//    public static ApplicationListByUserTypeDto convertToApplicationListUserTypeDto(Company company) {
//        ApplicationListByUserTypeDto applicationListDto = new ApplicationListByUserTypeDto();
//        applicationListDto.setRegistrationDate(company.getRegistrationDate());
//        applicationListDto.setApplicationId(company.getCompanyId());
//        applicationListDto.setFullName(company.getManagerUser().getFullName());
//        applicationListDto.setBuyerType(company.getManagerUser().getBuyerType());
//        applicationListDto.setCompanyName(company.getCompanyName());
//        return applicationListDto;
//    }
}
