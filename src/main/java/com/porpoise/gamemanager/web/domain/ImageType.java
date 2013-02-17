package com.porpoise.gamemanager.web.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 2/16/13
 * Time: 11:28 AM
 */
public enum ImageType {
    FANART("fanart"),
    BOXART("boxart"),
    CLEARLOGO("clearlogo"),
    BANNER("banner"),
    SCREENSHOT("screenshot"),
    CONSOLE("console"),
    CONTROLLER("controller");

    private final String value;
    private static final Map<String, ImageType> enumMap =  new HashMap<String, ImageType>();

    ImageType(String value) {
        this.value = value;
    }

    static {
        for(ImageType type : ImageType.values()) {
            enumMap.put(type.value, type);
        }
    }

    public static ImageType get(String value) {
        return enumMap.get(value);
    }

    public String value() {
        return value;
    }
}
