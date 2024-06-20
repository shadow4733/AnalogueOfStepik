package com.user_management_service.repository;

import com.user_management_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByUsername(String username);

    boolean existsByEmail(String username);

    User findByEmailToken(String token);

    User findByUsername(String username);
}
