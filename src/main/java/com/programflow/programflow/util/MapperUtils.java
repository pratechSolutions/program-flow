package com.programflow.programflow.util;

import com.programflow.programflow.dto.AssemblyDto;
import com.programflow.programflow.dto.request.AssemblyRequestDto;
import com.programflow.programflow.repository.entity.Assembly;
import jdk.internal.event.Event;


public class MapperUtils {


    public static AssemblyDto mapToAssemblyDto(Event assembly) {
        AssemblyDto assemblyDto = new AssemblyDto();
        assemblyDto.setAssemblyDescription("Address Line :" + assembly.getAssemblyDescription() + ", " + assembly.getCity() + ", " + assembly.getCountry().toString() + ", " + assembly.getPostalCode());
        assemblyDto.setAssemblyStartDate(assembly.getAssemblyStartDate());
        assemblyDto.setAssemblyEndDate(assembly.getAssemblyEndDate());
        assemblyDto.setAssemblyLink(assembly.getAssemblyLink());

        return assemblyDto;
    }

    public static AssemblyRequestDto mapToEventRequestDto(Assembly assembly) {
        AssemblyRequestDto assemblyRequestDto = new AssemblyRequestDto();
        assemblyRequestDto.setAssemblyName(assembly.getAssemblyName());
        assemblyRequestDto.setPhoneNumber(assembly.getPhoneNumber());
        assemblyRequestDto.setAddressLine(assembly.getAddressLine());

        return assemblyRequestDto;
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
