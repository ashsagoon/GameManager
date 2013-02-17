package com.porpoise.gamemanager.web.dao;

import com.google.code.morphia.dao.DAO;
import com.porpoise.gamemanager.web.domain.User;
import org.bson.types.ObjectId;

public interface UserDAO extends DAO<User, ObjectId> {
    User getUserByUsername(String username);

    String createUser(User user);
}
