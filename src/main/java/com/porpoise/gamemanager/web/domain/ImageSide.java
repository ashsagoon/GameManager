package com.porpoise.gamemanager.web.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 11:28 AM
 */
public enum ImageSide {
    LEFT("left"),
    RIGHT("right"),
    TOP("top"),
    BOTTOM("bottom"),
    FRONT("front"),
    BACK("back");

    private String value;
    private static final Map<String, ImageSide> enumMap = new HashMap<String, ImageSide>();

    ImageSide(String value) {
        this.value = value;
    }

    static {
        for(ImageSide type : ImageSide.values()) {
            enumMap.put(type.value, type);
        }
    }

    public static ImageSide get(String value) {
        return enumMap.get(value);
    }

    public String value() {
        return value;
    }

}
