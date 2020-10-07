package com.programflow.programflow.dto.request;


import com.programflow.programflow.enums.Country;
import com.programflow.programflow.util.validators.PhoneNumber;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class EventRequestDto {


    @PhoneNumber
    private String phoneNumber;

    @Size(max = 250, message = "Address line cannot be longer than 250 characters.")
    @NotBlank(message = "Address line is mandatory")
    @ApiModelProperty(required = true)
    private String addressLine;

    @Size(max = 50)
    @NotBlank(message = "City is mandatory")
    @ApiModelProperty(required = true)
    private String city;

    @NotNull(message = "Country is mandatory")
    @ApiModelProperty(required = true)
    private Country country;

    @Size(max = 10)
    @NotBlank(message = "Postal/Zip Code is mandatory.")
    @ApiModelProperty(required = true)
    private String postalCode;
}
