package com.marco.cassandra.service;

import com.marco.cassandra.dao.UserRepository;
import com.marco.cassandra.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByAgeGreaterThanEqual(int age) {
        return userRepository.findByAgeGreaterThanEqual(age);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public  void update(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
