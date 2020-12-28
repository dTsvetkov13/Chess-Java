package models;

import common.Validator;

public class GameInfo
{
	private static GameInfo instance = null;
	
	private GameInfo()
	{
		
	}
	
	public static GameInfo getInstance()
	{
		if(Validator.isNull(instance))
		{
			instance = new GameInfo();
		}
		
		return instance;
	}
}
