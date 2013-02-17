package com.porpoise.gamemanager.web.service;

import com.google.gson.Gson;
import com.porpoise.gamemanager.web.dao.GameDAO;
import com.porpoise.gamemanager.web.dao.UserDAO;
import com.porpoise.gamemanager.web.domain.Game;
import com.porpoise.gamemanager.web.domain.User;
import com.porpoise.gamemanager.web.domain.UserGame;
import com.porpoise.thegamesdb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/14/13
 * Time: 8:08 PM
 */
@Path("/user")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private Gson gson;

    @GET
   	@Produces("text/plain")
   	@Path("/search/{game}")
    public String getGamesList(@PathParam("game") String game) {
                TheGamesDBClient theGamesDBClient = new TheGamesDBClient();
                List<GamesDBGame> data = TheGamesDBClient.getGamesList(game);
                GamesDBGameDetails gameDetails = data.get(0).getGameDetails();
                GamesDBImages gamesDBImages = data.get(0).getImages();
                List<GamesDBPlatform> platforms = TheGamesDBClient.getPlatformsList();
                List<GamesDBGame> platformGames = platforms.get(0).getGames();
                GamesDBGameDetails gameDetails1 = platformGames.get(0).getGameDetails();
                List<GamesDBGame> platforms1 = TheGamesDBClient.getPlatFormGames("microsoft xbox 360");
                GamesDBUpdate gamesDBUpdate = TheGamesDBClient.updates(20000);
                GamesDBGameDetails gameDetails2 = gamesDBUpdate.getGames().get(0).getGameDetails();
        //        GameImage test = gameDetails.getGame().getGameImages().getScreenshots().get(0);
        //        GameArtData gameArtData = theGamesDBClient.getArt(2);
        //        PlatformListData gamePlatformData = theGamesDBClient.getPlatformsList();
        //        PlatformData platformData = theGamesDBClient.getPlatform(6);
        //        GamesListData getPlatformGames = theGamesDBClient.getPlatformGames(1);
        //        GamesListData platformGames = theGamesDBClient.platformGames("Microsoft Xbox 360");
        //        UpdateItems updateItems = theGamesDBClient.updates(20000);
        //        SteamId steamId = null;
        //        Map<Integer, SteamGame> games;
        //        try {
        //            steamId = SteamId.create("ashsagoon");
        //            games = steamId.getGames();
        //        } catch (SteamCondenserException e) {
        //            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        //        }
//        User user1 = new User();
//        user1.setUsernameLower("blah");
//        user1.setUsername("blah");
//        userDAO.createUser(user1);
//        User user = userDAO.getUserByUsername("blah");

        return "complete";
    }

    @POST
    @Consumes("application/json")
   	@Produces("application/json")
   	@Path("/create")
    public String createUser(User user) {
//        userDAO.createUser(user);
        return gson.toJson("ok");
    }

    @GET
    @Produces("application/json")
    @Path("/{userId}")
    public String getUser(@PathParam("userId") String userId) {
        return gson.toJson(userDAO.getUserByUsername(userId));
    }
}
