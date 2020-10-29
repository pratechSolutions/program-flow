package com.programflow.programflow.service.impl;


import com.programflow.programflow.dto.AssemblyDto;
import com.programflow.programflow.dto.UserDto;
import com.programflow.programflow.dto.request.AssemblyRequestDto;
import com.programflow.programflow.exception.ProgramFlowException;
import com.programflow.programflow.repository.AssemblyRepository;
import com.programflow.programflow.repository.UserRepository;
import com.programflow.programflow.repository.entity.Assembly;
import com.programflow.programflow.repository.entity.User;
import com.programflow.programflow.service.AssemblyService;
import com.programflow.programflow.service.WebClientUserService;
import com.programflow.programflow.util.MapperUtils;
import jdk.internal.event.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.programflow.programflow.exception.ErrorType.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssemblyServiceImpl implements AssemblyService {

    private AssemblyRepository assemblyRepository;
    private UserRepository userRepository;
    private WebClientUserService webClientUserService;
    private AssemblyRequestDto assemblyRequestDto;


    public String addAssembly(AssemblyRequestDto assemblyRequestDto, String assemblyId) {
        UserDto userDto =
                webClientUserService.findByUserId(assemblyId).orElseThrow(() -> new ProgramFlowException(USER_NOT_FOUND));

        if (!(userDto.getAssemblyId() == null)) {
            throw new ProgramFlowException(USER_HAS_ALREADY_ASSEMBLY);
        }

        Assembly assembly = new Assembly();
        assembly.setAssemblyName(assemblyRequestDto.getAssemblyName());
        assembly.setPhoneNumber(assemblyRequestDto.getPhoneNumber());
        assembly.setAddressLine(assemblyRequestDto.getAddressLine());
        assembly.setAssemblyDescription(assemblyRequestDto.getAssemblyDescription());
        assembly.setCity(assemblyRequestDto.getCity());
        assembly.setPostalCode(assemblyRequestDto.getPostalCode());
        assembly.setCountry(assemblyRequestDto.getCountry());
        assembly.setAssemblyStartDate(assemblyRequestDto.getAssemblyStartDate());
        assembly.setAssemblyEndDate(assemblyRequestDto.getAssemblyEndDate());
        assembly.setAssemblyLink(assemblyRequestDto.getAssemblyLink());
        assembly.setAssemblyId(UUID.randomUUID().toString());

        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserId(assemblyId);
        assembly.setManagerUser(user);

        userDto.setPhoneNumber(assemblyRequestDto.getPhoneNumber());
        userDto.setAssemblyId(assembly.getAssemblyId());
        webClientUserService.updateUser(userDto, user.getUserId());

        return assemblyRepository.save().getAssemblyId();
    }

    @Override
    public AssemblyDto getAssemblyByAssemblyId(String assemblyId) {

        Assembly assembly =
                assemblyRepository.getAssemblyByAssemblyId(assemblyId).orElseThrow(() -> new ProgramFlowException(ASSEMBLY_NOT_FOUND));
                return MapperUtils.mapToAssemblyDto(assembly);

    }

}