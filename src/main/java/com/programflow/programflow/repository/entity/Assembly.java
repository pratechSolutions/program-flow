package com.programflow.programflow.repository.entity;

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
public class Assembly {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String assemblyId;

    private String assemblyName;

    private String addressLine;

    @Column(unique = true)
    private String phoneNumber;

    private Country country;

    private String assemblyDescription;

    private String city;

    private Date assemblyStartDate;

    private Date assemblyEndDate;

    private String assemblyLink;

    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL) // necati abiye sor!
    private User managerUser;
}