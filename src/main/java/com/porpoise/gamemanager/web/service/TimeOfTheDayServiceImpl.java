package com.porpoise.gamemanager.web.service;

import com.porpoise.thegamesdb.client.*;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Component
@Path("/timeoftheday")
public class TimeOfTheDayServiceImpl implements TimeOfTheDayService {
	private static String PATTERN = "MM.dd.yyyy HH:mm:ss";

	@GET
	@Produces("text/plain")
	@Path("/search/{game}")
	public String getTimeOfTheDay(@PathParam("game") String game) {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet request = new HttpGet("http://thegamesdb.net/api/GetGamesList.php?name=halo");
//        String line = "";
//        Data data = null;
//        try {
//            HttpResponse response = httpClient.execute(request);
//            JAXBContext context = JAXBContext.newInstance(Data.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            data = (Data)unmarshaller.unmarshal(response.getEntity().getContent());
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        } catch (JAXBException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//
//        SimpleDateFormat df = new SimpleDateFormat(PATTERN);
////		return df.format(Calendar.getInstance().getTime());
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
        return "complete";
	}

	@GET
	@Produces("application/xml")
	@Path("/asxml/{name}/")
	public Time getTimeOfTheDayInXML(@PathParam("name") String name) {
		SimpleDateFormat df = new SimpleDateFormat(PATTERN);
		Time t = new Time();
		t.setName(name);
		t.setTime(df.format(Calendar.getInstance().getTime()));
		return t;
	}

	@GET
	@Produces("application/json")
	@Path("/asjson/{name}/")
	public Time getTimeOfTheDayInJSON(@PathParam("name") String name) {
		SimpleDateFormat df = new SimpleDateFormat(PATTERN);
		Time t = new Time();
		t.setName(name);
		t.setTime(df.format(Calendar.getInstance().getTime()));
		return t;
	}
}