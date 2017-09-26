package com.boss.brainer.service;

import com.boss.brainer.domain.mysql.User;

public interface UserService {

    User fingByUsername(String username);
}
