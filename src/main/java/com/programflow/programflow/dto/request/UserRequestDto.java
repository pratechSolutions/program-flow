package com.programflow.programflow.dto.request;


import com.programflow.programflow.util.validation.Email;
import com.programflow.programflow.util.validation.Password;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Full Name is mandatory.")
    @Size(max = 50, message = "Full Name can not be more then 50 characters.")
    @ApiModelProperty(required = true)
    private String fullName;


    @Email
    @ApiModelProperty(required = true)
    private String email;

    @Password
    @ApiModelProperty(required = true)
    private String password;

    @NotBlank(message = "Event Name is mandatory.")
    @Size(max = 50, message = "Event Name can not be more then 50 characters.")
    @ApiModelProperty(required = true)
    private String eventName;

}

