package com.porpoise.gamemanager.web.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.porpoise.gamemanager.web.domain.Game;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 3:55 PM
 */
@Repository
public class GameDAOImpl extends BasicDAO<Game, ObjectId> implements GameDAO {

    @Autowired
    public GameDAOImpl(Datastore datastore) {
        super(Game.class, datastore);
    }

    public Game getGame(int gamesDBId) {
        return getDatastore().find(Game.class).field("gamesDBId").equal(gamesDBId).get();
    }

    public void createGame(Game game) {
        getDatastore().save(game);
    }
}
