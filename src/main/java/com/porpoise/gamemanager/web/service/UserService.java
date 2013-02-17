package com.porpoise.gamemanager.web.service;

import com.porpoise.gamemanager.web.domain.User;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/14/13
 * Time: 8:07 PM
 */
public interface UserService {
    public String getGamesList(String game);

    public String createUser(User user);

    public String getUser(String userId);
}
