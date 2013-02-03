package com.porpoise.gamemanager.web.service;

public interface TimeOfTheDayService {

	public abstract String getTimeOfTheDay(String game);

	public abstract Time getTimeOfTheDayInXML(String name);

	public abstract Time getTimeOfTheDayInJSON(String name);

}