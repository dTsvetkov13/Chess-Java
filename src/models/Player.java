package models;

import common.Constants;
import common.Validator;
import enums.Team;
import models.figures.Figure;

public class Player {
	
	private String username;
	private Team Team;
	private Figure[] takenFigures;
	private int takenFiguresIndex;
	
	public String getUsername()
	{
		return username;
	}
	
	public Team getTeam()
	{
		return Team;
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
		if(Validator.isNullOrEmpty(username))
		{
			this.username = username;
		}
	}
	
	public void setTeam(Team team) 
	{
		if(team == Team.Black || team == Team.White)
		{
			this.Team = team;
		}
	}
	
	public void setTakenFigures(Figure[] takenFigures) 
	{
		this.takenFigures = takenFigures;
	}
	
	//TO DO: should be optimize
	public Player()
	{
		setUsername("Player1");
		setTeam(Team.Black);
		setTakenFigures(new Figure[Constants.MAX_FIGURES_TAKEN_COUNT]);
	}	
	
	public Player(String username, Team Team)
	{
		setUsername(username);
		setTeam(Team);
		setTakenFigures(new Figure[Constants.MAX_FIGURES_TAKEN_COUNT]);
	}
	
	public Player(String username, Team Team, Figure[] takenFigures)
	{
		setUsername(username);
		setTeam(Team);
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
