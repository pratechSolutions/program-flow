package com.programflow.programflow.controller;

import com.programflow.programflow.dto.EventDto;
import com.programflow.programflow.dto.request.EventRequestDto;
import com.programflow.programflow.service.EventService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/event")
public class EventController {

    private final EventService eventService;

    @PostMapping("/{userId}")
    @ApiOperation(value = "Add Company", httpMethod = "POST")
    public ResponseEntity<String> addEvent(@RequestBody @Valid EventRequestDto eventRequestDto,
                                           @PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.addEvent(eventRequestDto, userId));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEvent(@PathVariable String eventId) {
        return ResponseEntity.ok(eventService.getEventByEventId(eventId));
    }
}
