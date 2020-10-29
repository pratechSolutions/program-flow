package com.programflow.programflow.controller;

import com.programflow.programflow.dto.AssemblyDto;
import com.programflow.programflow.dto.request.AssemblyRequestDto;
import com.programflow.programflow.service.AssemblyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/assembly")
public class AssemblyController {

    private final AssemblyService assemblyService;

    @PostMapping("/{userId}")
    @ApiOperation(value = "Add Assembly", httpMethod = "POST")
    public ResponseEntity<String> addAssembly(@RequestBody @Valid AssemblyRequestDto assemblyRequestDto,
                                           @PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(assemblyService.addAssembly(assemblyRequestDto, userId));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<AssemblyDto> getAssembly(@PathVariable String assemblyId) {
        return ResponseEntity.ok(assemblyService.getAssemblyByAssemblyId(assemblyId));
    }
}
