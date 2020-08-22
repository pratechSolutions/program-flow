package com.programflow.programflow.controller;


import com.programflow.programflow.dto.EventDTO;
import com.programflow.programflow.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EventController {


    @PostMapping ( "/event")
    public ResponseEntity<HttpStatus> createEvent(@RequestBody @Valid EventDTO eventDTO){
        return new ResponseEntity(HttpStatus.CREATED);
    }

}


