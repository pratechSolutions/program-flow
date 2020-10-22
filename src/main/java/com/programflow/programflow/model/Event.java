package com.programflow.programflow.model;

import com.programflow.programflow.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Event {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String eventId;

    private String eventName;

    private String addressLine;

    @Column(unique = true)
    private String phoneNumber;

    private Country country;

    private String eventDescription;

    private String city;

    private Date eventStartDate;

    private Date eventEndDate;

    private String eventLink;

    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL) // necati abiye sor!
    private User managerUser;
}