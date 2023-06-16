package com.preproject.pp_3_1_2.service;


import com.preproject.pp_3_1_2.model.User;

import java.util.List;


public interface UserService {

    public User getUserById(Long id);

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void deleteUser(Long id);

    public void editeUser(User user);
}
