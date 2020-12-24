package enums;

public enum Directions 
{
	East,
	West,
	North,
	South,
	UpperLeft,
	LowerLeft,
	UpperRight,
	LowerRight,
	KingSideCastling,
	QueenSideCastling
	
	//idea for Castling values - when MovementInDirection has Castling as a direction, the 
	//Coordinates array has two Coordinates in it - first the cell where the King can go,
	//and next the cells where the Rook can go
}
