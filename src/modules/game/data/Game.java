package modules.game.data;

import model.GameInfo;
import model.PlayerInfo;
import modules.builder.BuilderMgr;
import modules.builder.data.BuilderHut;
import modules.map.data.Map;
import modules.object.ObjectMgr;
import modules.object.data.ObjectUtils;
import modules.object.data.createdObject.ClanCastle;
import modules.object.data.createdObject.TownHall;
import modules.object.data.createdObject.armyObject.ArmyCamp;
import modules.object.data.createdObject.armyObject.Barrack;
import modules.object.data.createdObject.harvestObject.GoldMine;
import modules.object.data.staticObject.StaticObject;
import modules.shop.ShopMgr;
import org.json.JSONException;
import org.json.JSONObject;
import util.database.DataModel;

import java.awt.*;

public class Game extends DataModel {
    GameInfo gameInfo;
    PlayerInfo playerInfo;
    Resource resource;
    Map map;
    ObjectMgr objectMgr;
    BuilderMgr builderMgr;
    ShopMgr shopMgr;

    public Game(){
        super();
        objectMgr = new ObjectMgr();
        initGame();
    }

    public void initGame() {

        ObjectUtils objectUtils = new ObjectUtils();
        JSONObject initObjects = objectUtils.loadBaseConfig("InitGame", "map");

        JSONObject TOW_1 = null;
        JSONObject AMC_1 = null;
        JSONObject RES_1 = null;
        JSONObject BDH_1 = null;
        JSONObject CLC_1 = null;

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
        BuilderHut builderHut = new BuilderHut();
        ClanCastle clanCastle = new ClanCastle();

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

        System.out.println(((TownHall)objectMgr.getObject("TownHall", 1)).getCapacity());

//        for(int i=0; i < ObjectMgr.NUM_STATIC_OBJECT; ++i) {
//            StaticObject object = new StaticObject();
//            objectMgr.addObject(object);
//        }
//
//        resource = new Resource();
//        map = new Map();
//
//        ObjectUtils objectUtils = new ObjectUtils();
//        JSONObject initObjects = objectUtils.loadBaseConfig("InitGame", "map");
//        try {
//            System.out.println(initObjects.get("TOW_1"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

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
