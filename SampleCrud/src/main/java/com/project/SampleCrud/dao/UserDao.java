package com.project.SampleCrud.dao;

import com.project.SampleCrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    @Query("SELECT U FROM User U")
    List<User> getAllUsers();
}
