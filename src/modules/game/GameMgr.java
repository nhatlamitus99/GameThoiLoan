package modules.game;

import com.google.gson.Gson;
import modules.game.data.Game;
import modules.game.data.GameData;

public class GameMgr {
    Game game;
    GameData gameData;
    Gson gson;

    public GameMgr() {
        gson = new Gson();
        initGame();
        initGameData();
    }

    public void initGame() {
        game = new Game();
        System.out.println(gson.toJson(game));
    }

    public void initGameData() {
        if(game == null)
            return;
        gameData = new GameData();
        gameData.loadResource(game.getResource());
        gameData.loadPlayerInfo(game.getPlayerInfo());
        gameData.loadMapObject(game.getObjectMgr());
        System.out.println(gson.toJson(gameData));

    }
}
