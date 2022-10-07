package com.project.SampleCrud.service;

import com.project.SampleCrud.dto.UserDto;
import com.project.SampleCrud.dto.custom.ListResponseDto;
import com.project.SampleCrud.dto.custom.ResponseDto;
import com.project.SampleCrud.model.User;

public interface UserService {
    ResponseDto createUser(User user);

    ResponseDto getUser(Integer userId);

    ListResponseDto getAllUsers();

    ResponseDto updateUser(Integer userId, User user);

    ResponseDto deleteUser(Integer userId);
}
