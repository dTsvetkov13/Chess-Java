package models;

import common.Constants;
import enums.Team;
import models.figures.Figure;

public class Player {
	
	private String username;
	private Team Team;
	private Figure[] takenFigures;
	
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
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public void setTeam(Team team) 
	{
		this.Team = team;
	}
	public void setTakenFigures(Figure[] takenFigures) 
	{
		this.takenFigures = takenFigures;
	}
	//TO DO: should be optimize
	public Player()
	{
		this.username = "Player1";
		this.Team = Team.Black;
		this.takenFigures = new Figure[Constants.MAX_FIGURES_TAKEN_COUNT] ;
		
	}	
	public Player(String username, Team Team )
	{
		Team t = Team.Black;
		this.username = username;
		this.Team = Team;
	}
	public Player(String username, Team Team, Figure[] takenFigures)
	{
		this.username = username;
		this.Team = Team;
		this.takenFigures = takenFigures;
	}
	
	

}
