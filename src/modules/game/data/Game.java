package modules.game.data;

import model.GameInfo;
import model.PlayerInfo;
import modules.builder.BuilderMgr;
import modules.builder.data.BuilderHut;
import modules.map.data.Map;
import modules.object.ObjectMgr;
import modules.object.data.createdObject.TownHall;
import modules.object.data.createdObject.armyObject.Barrack;
import modules.object.data.createdObject.harvestObject.GoldMine;
import modules.object.data.staticObject.StaticObject;
import modules.shop.ShopMgr;
import util.database.DataModel;

public class Game extends DataModel {
    GameInfo gameInfo;
    PlayerInfo playerInfo;
    Resource resource;
    Map map;
    ObjectMgr objectMgr;
    BuilderMgr builderMgr;
    ShopMgr shopMgr;

    Game(){
        super();
        objectMgr = new ObjectMgr();
        initGame();
    }

    public void initGame() {
        TownHall townHall = new TownHall();
        GoldMine goldMine = new GoldMine();
        Barrack barrack = new Barrack();
        BuilderHut builderHut = new BuilderHut();

        objectMgr.addObject(townHall);
        objectMgr.addObject(goldMine);
        objectMgr.addObject(barrack);
        objectMgr.addObject(builderHut);

        for(int i=0; i < ObjectMgr.numStaticObject; ++i) {
            StaticObject object = new StaticObject();
            objectMgr.addObject(object);
        }

        resource = new Resource();
        map = new Map();

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
