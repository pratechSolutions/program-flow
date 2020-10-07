package com.programflow.programflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Data
public class EventDto {

    @NotNull
    private String eventName;

    private String eventDescription;

    private Date eventStartDate;

    private Date eventEndDate;

    private String eventLink;
}