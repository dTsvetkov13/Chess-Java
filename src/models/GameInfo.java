package models;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import common.Constants;
import common.Validator;
import enums.FigureType;
import models.figures.Figure;

public class GameInfo
{
	private static GameInfo instance = null;
	private Player[] players;
	private int playerOnTurnIndex;
	private Stack<Move> moves;
	HashMap<FigureType, ArrayList<Method>> figureMovements;
	HashMap<Method, ArrayList<FigureType>> movementsUsedBy;
	
	private GameInfo()
	{
		players = new Player[Constants.PLAYERS_COUNT];
		moves = new Stack<Move>();
		figureMovements = new HashMap<FigureType, ArrayList<Method>>();
		movementsUsedBy = new HashMap<Method, ArrayList<FigureType>>();
		
		this.setAllFigureMovements();
		this.setAllMovementsUsedBy();
	}
	
	public static GameInfo getInstance()
	{
		if(Validator.isNull(instance))
		{
			instance = new GameInfo();
		}
		
		return instance;
	}
	
	private void setAllFigureMovements()
	{
		try
		{
			figureMovements.put(FigureType.Bishop, new ArrayList<Method>());
			figureMovements.put(FigureType.Rook, new ArrayList<Method>());
			figureMovements.put(FigureType.Queen, new ArrayList<Method>());
			figureMovements.put(FigureType.King, new ArrayList<Method>());
			figureMovements.put(FigureType.Knight, new ArrayList<Method>());
			figureMovements.put(FigureType.Pawn, new ArrayList<Method>());
			
			this.addMethodToFigureType(FigureType.Bishop, "diagonal");
			this.addMethodToFigureType(FigureType.Rook, "vertical");
			this.addMethodToFigureType(FigureType.Queen, "vertical");
			this.addMethodToFigureType(FigureType.Queen, "diagonal");
			this.addMethodToFigureType(FigureType.King, "kingMove");
			this.addMethodToFigureType(FigureType.King, "kingSideCastling");
			this.addMethodToFigureType(FigureType.King, "queenSideCastling");
			this.addMethodToFigureType(FigureType.Pawn, "pawnMove");
			this.addMethodToFigureType(FigureType.Knight, "knightMove");
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}
	
	private void addMethodToFigureType(FigureType figureType, String methodName)
	{
		try
		{
			figureMovements.get(figureType).add(MoveTypes.class.getMethod(methodName, Figure.class));
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}
	
	private void setAllMovementsUsedBy()
	{
		try
		{
			for(var figureType : this.figureMovements.keySet())
			{
				for(var method : this.figureMovements.get(figureType))
				{
					if(!this.movementsUsedBy.containsKey(method))
					{
						this.movementsUsedBy.put(method, new ArrayList<FigureType>());
					}
					
					this.movementsUsedBy.get(method).add(figureType);
				}
			}	
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
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
	
	public void addMove(Move move)
	{
		if(!Validator.isNull(move))
		{
			this.moves.push(move);
		}
	}
	
	public Move getLastMove()
	{
		return this.moves.get(this.moves.size() - 1);
	}
	
	//Add undo method
}