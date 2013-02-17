package com.porpoise.gamemanager.web.service;

import com.porpoise.gamemanager.web.domain.Game;

import java.util.List;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 11:34 AM
 */
public interface GameService {
    public String getGame(int id);

    public List<Game> search(String name);
}
