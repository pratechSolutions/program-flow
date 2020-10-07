package com.programflow.programflow.model;


import com.programflow.programflow.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

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

    @OneToOne(cascade = CascadeType.ALL)
    private User managerUser;

    private String eventName;

    private String addressLine;

    private Country country;

    private String eventDescription;

    private Date eventStartDate;

    private Date eventEndDate;

    private String eventLink;

    private String postalCode;

}