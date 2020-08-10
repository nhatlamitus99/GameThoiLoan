package cmd.send.demo;

import bitzero.server.extensions.data.BaseMsg;
import cmd.CmdDefine;
import com.google.gson.Gson;
import modules.game.data.GameData;

import java.nio.ByteBuffer;

/**
 * Created by CPU12750-local on 8/7/2020.
 */
public class ResponseGetInitGame extends BaseMsg {
    public GameData gameData;
    Gson gson = new Gson();

    public ResponseGetInitGame(GameData data) {
        super(CmdDefine.GET_INIT_GAME);
        try {
            gameData = data.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] createData() {
        ByteBuffer bf = makeBuffer();
        putStr(bf, gson.toJson(gameData).toString());
        return packBuffer(bf);
    }

}
