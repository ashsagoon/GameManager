package com.porpoise.gamemanager.web.domain;

import com.google.code.morphia.annotations.Reference;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 4:24 PM
 */
public class UserGame {
    @Reference
    private Game game;

    private String gameTitle;
    private boolean beaten = false;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public boolean isBeaten() {
        return beaten;
    }

    public void setBeaten(boolean beaten) {
        this.beaten = beaten;
    }
}
