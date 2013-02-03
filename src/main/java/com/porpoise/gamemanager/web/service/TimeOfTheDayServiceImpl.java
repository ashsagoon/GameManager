package com.porpoise.gamemanager.web.service;

import com.porpoise.thegamesdb.client.TheGamesDBClient;
import com.porpoise.thegamesdb.schema.GameData;
import com.porpoise.thegamesdb.schema.GamesListData;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        GamesListData data = theGamesDBClient.getGamesList(game);
        GameData gameData = theGamesDBClient.getGame(2);
        return data.toString();
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