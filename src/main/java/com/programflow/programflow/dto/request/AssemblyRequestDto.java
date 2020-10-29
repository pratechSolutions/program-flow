package com.programflow.programflow.dto.request;


import com.programflow.programflow.enums.Country;
import com.programflow.programflow.util.validation.PhoneNumber;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AssemblyRequestDto {

    @NotNull
    private String assemblyName;

    @PhoneNumber
    private String phoneNumber;

    @Size(max = 250, message = "Address line cannot be longer than 250 characters.")
    @NotBlank(message = "Address line is mandatory")
    @ApiModelProperty(required = true)
    private String addressLine;

    private String assemblyDescription;


    @Size(max = 50)
    @NotBlank(message = "City is mandatory")
    @ApiModelProperty(required = true)
    private String city;

    @Size(max = 10)
    @NotBlank(message = "Postal/Zip Code is mandatory.")
    @ApiModelProperty(required = true)
    private String postalCode;

    @NotNull(message = "Country is mandatory")
    @ApiModelProperty(required = true)
    private Country country;

    private Date assemblyStartDate;

    private Date assemblyEndDate;

    private String assemblyLink;

}


