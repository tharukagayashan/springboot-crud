package com.project.SampleCrud.service.impl;

import com.project.SampleCrud.dao.UserDao;
import com.project.SampleCrud.dto.custom.ListResponseDto;
import com.project.SampleCrud.dto.custom.ResponseDto;
import com.project.SampleCrud.model.User;
import com.project.SampleCrud.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResponseDto createUser(User user) {
        ResponseDto response = new ResponseDto();
        User saveUser = userDao.save(user);
        if (user.getId() != null) {
            response.setUser(saveUser);
            response.setMessage("USER CREATED!");
        } else {
            response.setMessage("USER CREATION FAILED!");
        }
        return response;
    }

    @Override
    public ResponseDto getUser(Integer userId) {

        ResponseDto response = new ResponseDto();
        Optional<User> optionalUser = userDao.findById(userId);
        if (optionalUser.isPresent()) {
            User saveUser = optionalUser.get();
            response.setUser(saveUser);
            response.setMessage("USER DATA FOUND");
        } else {
            response.setMessage("USER DATA NOT FOUND");
        }
        return response;
    }

    @Override
    public ListResponseDto getAllUsers() {

        ListResponseDto response = new ListResponseDto();
        List<User> users = userDao.getAllUsers();
        Integer count = users.size();
        response.setCount(count);
        response.setUsers(users);
        return response;

    }

    @Override
    public ResponseDto updateUser(Integer userId, User user) {

        ResponseDto response = new ResponseDto();
        Optional<User> optionalUser = userDao.findById(userId);
        if (optionalUser.isPresent()) {
            User updateUser = optionalUser.get();
            updateUser.setName(user.getName());
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            User saveUser = userDao.save(updateUser);
            response.setMessage("USER UPDATED");
            response.setUser(saveUser);
        } else {
            response.setMessage("USER UPDATE FAILED");
        }
        return response;
    }

    @Override
    public ResponseDto deleteUser(Integer userId) {
        ResponseDto response = new ResponseDto();
        Optional<User> optionalUser = userDao.findById(userId);
        if (optionalUser.isPresent()) {
            userDao.deleteById(optionalUser.get().getId());
            response.setMessage("USER DELETED");
            response.setUser(optionalUser.get());
        } else {
            response.setMessage("USER NOT FOUND");
            response.setUser(null);
        }
        return response;
    }
}