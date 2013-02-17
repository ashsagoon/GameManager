package com.porpoise.gamemanager.web.domain;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.porpoise.thegamesdb.client.GamesDBImage;
import org.bson.types.ObjectId;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 11:23 AM
 */
public class GameImage {
    @Id
    private ObjectId id;

    private ImageType type;
    private String url;
    private ImageSide side;
    private int width;
    private int height;
    private String thumb;

    public GameImage() {

    }

    public GameImage(GamesDBImage image, String baseImgUrl) {
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.url = baseImgUrl + image.getUrl();
        if(image.getThumb() != null) {
            this.thumb = baseImgUrl + image.getThumb();
        }
        this.type = ImageType.get(image.getType());
        this.side = ImageSide.get(image.getSide());
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageSide getSide() {
        return side;
    }

    public void setSide(ImageSide side) {
        this.side = side;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
