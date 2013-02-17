package com.porpoise.gamemanager.web.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.porpoise.gamemanager.web.domain.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BasicDAO<User, ObjectId> implements UserDAO {

    @Autowired
    public UserDAOImpl(Datastore datastore) {
        super(User.class, datastore);
    }

    public User getUserByUsername(String username) {
        return getDatastore().find(User.class).field("usernameLower").equal(username.toLowerCase()).get();
    }

    public String createUser(User user) {
        User existingUser = getUserByUsername(user.getUsername());
        if (existingUser != null) {
            return "Error: username taken";
        }
        getDatastore().save(user);
        return "ok";
    }
}
