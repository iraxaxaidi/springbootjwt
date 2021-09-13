package com.spring.security.jwt.service;

import com.spring.security.jwt.domain.Role;
import com.spring.security.jwt.domain.User;
import com.spring.security.jwt.repository.RoleRepo;
import com.spring.security.jwt.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation  implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {} ", roleName, userName);
        User user = userRepo.findByUserName(userName);
        Role role = roleRepo.findByName(roleName);

        user.getRole().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {}", userName);
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
