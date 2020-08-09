package com.app.demo.service.impl;

import com.app.demo.model.Role;
import com.app.demo.model.Status;
import com.app.demo.model.User;
import com.app.demo.repository.RoleRepository;
import com.app.demo.repository.UserRepository;
import com.app.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        List<Role> userRole = new ArrayList<>();
        userRole.add(role);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRole);
        user.setStatus(Status.ACTIVE);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
