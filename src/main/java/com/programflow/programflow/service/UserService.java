package com.programflow.programflow.service;

import com.programflow.programflow.dto.request.UserRequestDto;

public interface UserService {

    void createNewUser(UserRequestDto userDto);
}
