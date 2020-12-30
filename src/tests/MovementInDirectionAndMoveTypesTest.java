package tests;

import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;
import models.figures.Bishop;
import models.figures.Figure;
import models.figures.King;
import models.figures.Knight;
import models.figures.Pawn;
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
		//result - moves correctly
		Coordinates coor2 = new Coordinates(4, 5);
		Figure rook = new Rook(coor2, Team.Black);
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
		
		System.out.println("");
		
		//fourth - test on pawnMove, pawn not moved before
		//result - incorrect output
		Coordinates coor3 = new Coordinates(1, 1);
		Figure pawn = new Pawn(coor3, Team.Black);
		System.out.println("Type of Figure: Pawn");
		System.out.println("Current coordinates: " + coor3.getRow() + "; " + coor3.getColumn());
		MovementInDirection[] pawnMove = MoveTypes.pawnMove(pawn);
		for(int i = 0; i < pawnMove.length; i++)
		{
			System.out.println(pawnMove[i].toString());
		}
		
		System.out.println("");
		
		//fifth - test on pawnMove, pawn moved before
		//result - throws arrayIndexOutOfBounds exception
		/*Coordinates coor4 = new Coordinates(3, 3);
		Figure pawnMoved = new Pawn(coor4, Team.Black);
		System.out.println("Type of Figure: Pawn");
		System.out.println("Current coordinates: " + coor4.getRow() + "; " + coor4.getColumn());
		MovementInDirection[] pawnMove1 = MoveTypes.pawnMove(pawnMoved);
		for(int i = 0; i < pawnMove1.length; i++)
		{
			System.out.println(pawnMove1[i].toString());
		}
		*/
		
		//sixth - test on diagonal
		//result - throws IndexArrayOutOfBounds Exception
		Coordinates coor5 = new Coordinates(4, 3);
		Figure bishop = new Bishop(coor5, Team.Black);
		System.out.println("Type of Figure: Bishop");
		System.out.println("Current coordinates: " + coor5.getRow() + "; " + coor5.getColumn());
		MovementInDirection[] bishopMoves = MoveTypes.diagonal(bishop);
		for(int i = 0; i < bishopMoves.length; i++)
		{
			System.out.println(bishopMoves[i].toString());
		}

	}

}
