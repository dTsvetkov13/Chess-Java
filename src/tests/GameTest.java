package tests;

import enums.Team;
import models.Board;
import models.ChessGameEventListener;
import models.Coordinates;
import models.Game;
import models.GameInfo;
import models.Player;
import views.BoardView;
import views.screens.GameScreen;
import views.screens.MenuScreen;

public class GameTest
{
	public static void main(String[] args)
	{
		Game.getInstance().initialize(null, true);
		Game.getInstance().setListener(new ChessGameEventListener());
		GameInfo.getInstance().addPlayerAt(0, new Player());
		GameInfo.getInstance().addPlayerAt(1, new Player());
		GameInfo.getInstance().getPlayerAt(1).setTeam(Team.White);
		Game.getInstance().addScreen(new MenuScreen(""));
		Game.getInstance().run();
	}
}
