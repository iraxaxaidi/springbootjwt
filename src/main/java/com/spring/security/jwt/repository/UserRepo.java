package com.spring.security.jwt.repository;

import com.spring.security.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);

}
