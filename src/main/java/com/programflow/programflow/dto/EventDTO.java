package com.programflow.programflow.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class EventDTO {

    @NotNull
    @Valid
    private String eventName;

    @NotNull
    @Valid
    private String eventDescription;

    @NotNull
    @Valid
    private Date eventStartDate;

    @NotNull
    @Valid
    private Date eventEndDate;

    @NotNull
    @Valid
    private String eventLink;

    public EventDTO(String eventName, String eventDescription, Date eventStartDate, Date eventEndDate, String eventLink) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventLink = eventLink;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }
}


