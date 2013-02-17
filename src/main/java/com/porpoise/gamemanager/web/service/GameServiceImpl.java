package com.porpoise.gamemanager.web.service;

import com.google.gson.Gson;
import com.porpoise.gamemanager.web.dao.GameDAO;
import com.porpoise.gamemanager.web.domain.Game;
import com.porpoise.thegamesdb.client.TheGamesDBClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 11:35 AM
 */
@Path("/game")
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDAO gameDAO;

    @GET
   	@Produces("application/json")
   	@Path("/{id}")
    public String getGame(@PathParam("id") int id) {
        Gson gson = new Gson();
        Game game = gameDAO.getGame(id);
        if(game == null) {
            game = new Game(TheGamesDBClient.getGame(id));
            gameDAO.createGame(game);
        }
        return gson.toJson(game);
    }

    public List<Game> search(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
