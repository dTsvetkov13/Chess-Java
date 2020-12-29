package tests;

import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;
import models.figures.Figure;
import models.figures.King;
import models.figures.Knight;
import models.figures.Rook;

public class MovementInDirectionAndMoveTypesTest {

	public static void main(String[] args) {
		
		//first - test of knightMove
		//result - moves correctly
		Coordinates coor = new Coordinates(3, 2);
		Figure knight = new Knight(coor, Team.White);
		System.out.println("Type of figure: Knight");
		System.out.println("Current coordinates: " + coor.getRow() + "; " + coor.getColumn());
		MovementInDirection[] knightMoves = MoveTypes.knightMove(knight);
		for(int i = 0; i < knightMoves.length; i++)
		{
				System.out.println(knightMoves[i].toString());
		}
		
		System.out.println("");
		
		//second - test of KingMove
		//result - moves correctly for the capacity of the method
		Coordinates coor1 = new Coordinates(5, 3);
		Figure king = new King(coor1, Team.White);
		System.out.println("Types of figure: King");
		System.out.println("Current coordinates: " + coor1.getRow() + "; " + coor1.getColumn());
		MovementInDirection[] kingMoves = MoveTypes.kingMove(king);
		for(int i = 0; i < kingMoves.length; i++)
		{
			System.out.println(kingMoves[i].toString());
		}
		
		System.out.println("");
		
		//third - test on horizontal and vertical via Rook
		//result - incorrect output, problems with logic in MoveTypes.horizontal and vertical
		Coordinates coor2 = new Coordinates(4, 5);
		Figure rook = new Rook(coor1, Team.Black);
		System.out.println("Type of Figure: Rook");
		System.out.println("Current coordinates: " + coor2.getRow() + "; " + coor2.getColumn());
		MovementInDirection[] rookMoves1 = MoveTypes.horizontal(rook);
		MovementInDirection[] rookMoves2 = MoveTypes.vertical(rook);
		System.out.println("Horizontal moves: ");
		for(int i = 0; i < rookMoves1.length; i++)
		{
			System.out.println(rookMoves1[i].toString());
		}
		System.out.println("Vertical moves: ");
		for(int i = 0; i < rookMoves2.length; i++)
		{
			System.out.println(rookMoves2[i].toString());
		}

	}

}
