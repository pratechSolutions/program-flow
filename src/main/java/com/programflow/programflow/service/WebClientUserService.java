package com.programflow.programflow.service;

import com.programflow.programflow.dto.UserDto;

import java.util.Optional;

public interface WebClientUserService {

    Optional<UserDto> findByUserId(String userId);

    void updateUser(UserDto userDto, String userId);
}
