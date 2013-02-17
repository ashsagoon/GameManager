package com.porpoise.gamemanager.web.dao;

import com.porpoise.gamemanager.web.domain.Game;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 3:54 PM
 */
public interface GameDAO {
    public Game getGame(int id);

    public void createGame(Game game);
}
