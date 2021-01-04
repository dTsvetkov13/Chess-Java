package models;

import common.Constants;
import common.Validator;
import enums.Team;
import models.figures.Figure;

public class Player {
	
	private String username;
	private Team team;
	private Figure[] takenFigures;
	private int takenFiguresIndex;
	
	public String getUsername()
	{
		return username;
	}
	
	public Team getTeam()
	{
		return team;
	}
	
	public Figure[] getTakenFigures()
	{
		return takenFigures;
	}
	
	public int getTakenFiguresIndex()
	{
		return takenFiguresIndex;
	}
	
	public void setUsername(String username) 
	{
		if(!Validator.isNullOrEmpty(username))
		{
			this.username = username;
		}
	}
	
	public void setTeam(Team team) 
	{
		this.team = team;
	}
	
	public void setTakenFigures(Figure[] takenFigures) 
	{
		if(!Validator.isNull(takenFigures))
		{
			this.takenFigures = takenFigures;
		}
	}
	
	public Player()
	{
		this("Player1", Team.Black, new Figure[Constants.MAX_FIGURES_TAKEN_COUNT]);
	}	
	
	public Player(String username, Team team)
	{
		this(username, team, new Figure[Constants.MAX_FIGURES_TAKEN_COUNT]);
	}
	
	public Player(String username, Team team, Figure[] takenFigures)
	{
		setUsername(username);
		setTeam(team);
		setTakenFigures(takenFigures);
	}
	
	public void addTakenFigures(Figure takenFigure)
	{
		if (takenFigures!= null && takenFiguresIndex < takenFigures.length ) 
		{
			takenFigures[takenFiguresIndex] = takenFigure;
			takenFiguresIndex++;
		}
	}
	
	
	
	
	

}
