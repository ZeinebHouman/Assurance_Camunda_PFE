package com.bpm.workflow.repository;

import com.bpm.workflow.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    User findByFirstname(String username);
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);
}
