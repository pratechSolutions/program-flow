package com.programflow.programflow.service;

import com.programflow.programflow.dto.AssemblyDto;
import com.programflow.programflow.dto.request.AssemblyRequestDto;

public interface AssemblyService {

    String addAssembly(AssemblyRequestDto assemblyRequestDto, String userId);

    AssemblyDto getAssemblyByAssemblyId(String eventId);
}
