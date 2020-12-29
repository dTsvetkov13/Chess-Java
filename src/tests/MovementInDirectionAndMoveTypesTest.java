package tests;

import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;
import models.figures.Figure;
import models.figures.Knight;

public class MovementInDirectionAndMoveTypesTest {

	public static void main(String[] args) {
		
		//first - test of knightMove
		// isn't correct, allows capturing of figures of one's own team but not of the opposite
		Coordinates coor = new Coordinates(3, 2);
		Figure knight = new Knight(coor, Team.White);
		System.out.println("Type of figure: Knight");
		System.out.println("Current coordinates: " + coor.getRow() + "; " + coor.getColumn());
		MovementInDirection[] knightMoves = MoveTypes.knightMove(knight);
		for(int i = 0; i < knightMoves.length; i++)
		{
				System.out.println(knightMoves[i].toString());
		}

	}

}
