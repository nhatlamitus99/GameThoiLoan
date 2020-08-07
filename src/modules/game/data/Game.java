package modules.game.data;

import com.google.gson.Gson;
import model.GameInfo;
import model.PlayerInfo;
import modules.builder.BuilderMgr;
import modules.map.data.Map;
import modules.object.ObjectMgr;
import modules.object.data.MapObject;
import modules.object.data.ObjectUtils;
import modules.object.data.createdObject.BuilderHut;
import modules.object.data.createdObject.ClanCastle;
import modules.object.data.createdObject.TownHall;
import modules.object.data.createdObject.armyObject.ArmyCamp;
import modules.object.data.createdObject.armyObject.Barrack;
import modules.object.data.createdObject.defenseObject.DefenseObject;
import modules.object.data.createdObject.harvestObject.GoldMine;
import modules.object.data.staticObject.StaticObject;
import modules.shop.ShopMgr;
import org.json.JSONException;
import org.json.JSONObject;
import util.database.DataModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    GameInfo gameInfo;
    PlayerInfo playerInfo;
    Resource resource;
    Map map;
    ObjectMgr objectMgr;
    BuilderMgr builderMgr;
    ShopMgr shopMgr;


    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public ObjectMgr getObjectMgr() {
        return objectMgr;
    }

    public void setObjectMgr(ObjectMgr objectMgr) {
        this.objectMgr = objectMgr;
    }


    public Game(){
        super();
        objectMgr = new ObjectMgr();
        initGame();
    }

    public void initGame() {

        ObjectUtils objectUtils = new ObjectUtils();
        JSONObject initObjects = objectUtils.loadBaseConfig("InitGame", "map");
        JSONObject initPlayer = objectUtils.loadBaseConfig("InitGame", "player");
        JSONObject initObs = objectUtils.loadBaseConfig("InitGame", "obs");

        JSONObject TOW_1 = null;
        JSONObject AMC_1 = null;
        JSONObject RES_1 = null;
        JSONObject BDH_1 = null;
        JSONObject CLC_1 = null;
        ArrayList<StaticObject> listObs = new ArrayList<StaticObject>();


        try {
            TOW_1 = initObjects.getJSONObject("TOW_1");
            AMC_1 = initObjects.getJSONObject("AMC_1");
            RES_1 = initObjects.getJSONObject("TOW_1");
            BDH_1 = initObjects.getJSONObject("BDH_1");
            CLC_1 = initObjects.getJSONObject("CLC_1");
        } catch (JSONException e) {
            e.printStackTrace();
        }



        TownHall townHall = objectMgr.loadTownHall(1);
        ArmyCamp armyCamp = objectMgr.loadArmyCamp(1);
        GoldMine goldMine = objectMgr.loadGoldMine(1);
        BuilderHut builderHut = objectMgr.loadBuilderHut(1);
        ClanCastle clanCastle = objectMgr.loadClanCastle(1);


        try {
            resource = new Resource(initPlayer.getInt("gold"),
                    initPlayer.getInt("elixir"),
                    initPlayer.getInt("coin"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            int iterator = 0;
            while (true){
                ++iterator;
                JSONObject jsonStaticObject = null;
                try {
                    jsonStaticObject = initObs.getJSONObject(iterator + "");
                    String typeObs = jsonStaticObject.getString("type");
                    StaticObject staticObject = objectMgr.loadStaticObject(typeObs);
                    staticObject.setPosition(new Point(jsonStaticObject.getInt("posX"), jsonStaticObject.getInt("posY")));
                    listObs.add(staticObject);

                } catch (JSONException e) {
                    break;
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listObs.size(); i++) {
            objectMgr.addObject(listObs.get(i));
        }


        try {
            townHall.setPosition(new Point(TOW_1.getInt("posX"), TOW_1.getInt("posY")));
            armyCamp.setPosition(new Point(AMC_1.getInt("posX"), AMC_1.getInt("posY")));
            goldMine.setPosition(new Point(RES_1.getInt("posX"), RES_1.getInt("posY")));
            builderHut.setPosition(new Point(BDH_1.getInt("posX"), BDH_1.getInt("posY")));
            clanCastle.setPosition(new Point(CLC_1.getInt("posX"), CLC_1.getInt("posY")));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        objectMgr.addObject(townHall);
        objectMgr.addObject(goldMine);
        objectMgr.addObject(armyCamp);
        objectMgr.addObject(builderHut);
        objectMgr.addObject(clanCastle);
    }

    public void updateResource(Resource r){

    }

    public void playGame(){

    }

    public void sendGame(){

    }

    public  void response(){

    }
}
