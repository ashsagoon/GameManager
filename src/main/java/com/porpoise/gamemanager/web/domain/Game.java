package com.porpoise.gamemanager.web.domain;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Reference;
import com.porpoise.thegamesdb.client.GamesDBGameDetails;
import com.porpoise.thegamesdb.client.GamesDBImage;
import com.porpoise.thegamesdb.client.GamesDBImages;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 11:18 AM
 */
public class Game {
    @Id
    private ObjectId id;

    private int gamesDBId;

    @Indexed
    private String gameTitle;

    private Date releaseDate;

    @Indexed
    private String platform;

    private String thumb;
    private String overview;
    private String ESRB;
    private List<String> genres;
    private String players;
    private String coop;
    private String youtube;
    private String publisher;
    private String developer;
    private double rating;
    private List<GameImage> images;

    public Game() {

    }

    public Game(GamesDBGameDetails game) {
        this.gamesDBId = game.getId();
        this.gameTitle = game.getGameTitle();
        this.releaseDate = game.getReleaseDate();
        this.platform = game.getPlatform();
        this.overview = game.getOverview();
        this.ESRB = game.getESRB();
        this.genres = game.getGenres();
        this.players = game.getPlayers();
        this.coop = game.getCoop();
        this.youtube = game.getYoutube();
        this.publisher = game.getPublisher();
        this.developer = game.getDeveloper();
        this.rating = game.getRating();
        this.images = new ArrayList<GameImage>();
        GamesDBImages gameImages = game.getImages();
        if(gameImages != null) {
            for(GamesDBImage gamesDBImage : game.getImages().getImages()) {
                GameImage image = new GameImage(gamesDBImage, gameImages.getBaseImgUrl());
                images.add(image);
                if(ImageType.BOXART.equals(image.getType()) &&
                        ImageSide.FRONT.equals(image.getSide())) {
                    this.thumb = image.getThumb();
                }
            }
        }
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getGamesDBId() {
        return gamesDBId;
    }

    public void setGamesDBId(int gamesDBId) {
        this.gamesDBId = gamesDBId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getESRB() {
        return ESRB;
    }

    public void setESRB(String ESRB) {
        this.ESRB = ESRB;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getCoop() {
        return coop;
    }

    public void setCoop(String coop) {
        this.coop = coop;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<GameImage> getImages() {
        return images;
    }

    public void setImages(List<GameImage> images) {
        this.images = images;
    }
}
