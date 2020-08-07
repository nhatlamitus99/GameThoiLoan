package modules.game;

import com.google.gson.Gson;
import modules.game.data.Game;
import modules.game.data.GameData;

public class GameMgr {
    Game game = new Game();
    GameData gameData = new GameData();
    Gson gson = new Gson();

    public GameMgr() {
        gameData.loadResource(game.getResource());
        gameData.loadPlayerInfo(game.getPlayerInfo());
        gameData.loadMapObject(game.getObjectMgr());
        System.out.println(gson.toJson(gameData));
    }
}
