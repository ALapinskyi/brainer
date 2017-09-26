package com.boss.brainer.repository;

import com.boss.brainer.domain.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    User findOneByUsername(String username);
}
