package models;

import common.Constants;
import common.Validator;

public class GameInfo
{
	private static GameInfo instance = null;
	private Player[] players;
	private int playerOnTurnIndex;
	
	private GameInfo()
	{
		players = new Player[Constants.PLAYERS_COUNT];
	}
	
	public static GameInfo getInstance()
	{
		if(Validator.isNull(instance))
		{
			instance = new GameInfo();
		}
		
		return instance;
	}
	
	public void changeTurn()
	{
		this.playerOnTurnIndex++;
		
		if(this.playerOnTurnIndex >= this.players.length)
		{
			this.playerOnTurnIndex = 0;
		}
	}
	
	public Player getPlayerOnTurn()
	{
		return this.players[this.playerOnTurnIndex];
	}
	
	public void addPlayerAt(int index, Player player)
	{
		if(!Validator.isNull(player))
		{
			if(Validator.isLessThan(this.players.length, index))
			{
				this.players[index] = player;
			}
		}
	}
	
	public Player getPlayerAt(int index)
	{
		if(Validator.isGreaterThan(-1, index)
			&& Validator.isLessThan(this.players.length, index))
		{
			return this.players[index];
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
}
