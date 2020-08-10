package cmd.send.demo;

import bitzero.server.extensions.data.BaseMsg;

import cmd.CmdDefine;

import java.nio.ByteBuffer;

import com.google.gson.Gson;
import model.PlayerInfo;
import modules.game.GameMgr;
import modules.game.data.GameData;

public class ResponseRequestUserInfo extends BaseMsg {
    public PlayerInfo info;
    GameMgr gameMgr = new GameMgr();
    GameData gameData = gameMgr.getGameData();
    Gson gson = new Gson();

    public ResponseRequestUserInfo(PlayerInfo _info) {
        super(CmdDefine.GET_USER_INFO);
        info = _info;
        gameData.loadPlayerInfo(info);
    }
    
    @Override
    public byte[] createData() {
        ByteBuffer bf = makeBuffer();
        putStr(bf, gson.toJson(gameData).toString());

        return packBuffer(bf);
    }
}
