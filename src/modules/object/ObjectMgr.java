package modules.object;

import com.google.gson.Gson;
import modules.map.data.Map;
import modules.object.data.MapObject;
import modules.object.data.createdObject.BuilderHut;
import modules.object.data.createdObject.ClanCastle;
import modules.object.data.createdObject.CreatedObject;
import modules.object.data.createdObject.TownHall;
import modules.object.data.createdObject.armyObject.ArmyCamp;
import modules.object.data.createdObject.armyObject.Barrack;
import modules.object.data.createdObject.harvestObject.GoldMine;
import modules.object.data.staticObject.StaticObject;
import org.json.JSONException;
import org.json.JSONObject;
import util.database.DataModel;

import java.awt.*;
import java.util.*;
import java.util.List;


public class ObjectMgr extends DataModel {
    public static final int NUM_STATIC_OBJECT = 57;
    private HashMap<String, ArrayList<MapObject>> listObject;

    public ObjectMgr() {
        super();
        listObject = new HashMap<String, ArrayList<MapObject>>();
    }

    public void addObject(MapObject object) {

        if(listObject.containsKey(object.getTypeObj())) {
            object.setId(listObject.get(object.getTypeObj()).size());
            listObject.get(object.getTypeObj()).add(object);
        }
        else {
            ArrayList<MapObject> list = new ArrayList<MapObject>();
            object.setId(0);
            list.add(object);
            listObject.put(object.getTypeObj(), list);
        }



    }

    public HashMap<String, ArrayList<MapObject>> getListObject() {
        return listObject;
    }

    public MapObject getObject(String type, int id) {
        return listObject.get(type).get(id);

    }

    public TownHall loadTownHall(int level) {
        TownHall townHall = new TownHall();
        townHall.setLevel(level);
        try {
            JSONObject hall = townHall.loadConfig(level);
            townHall.setSize(hall.getInt("height"));
            townHall.setHitPoints(hall.getInt("hitpoints"));
            townHall.setCapacity(hall.getInt("capacity"));
            townHall.setBuildingTime(hall.getInt("buildTime"));
            townHall.setCapacityGold(hall.getInt("capacityGold"));
            townHall.setCapacityElixir(hall.getInt("capacityElixir"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return townHall;
    }

    public ArmyCamp loadArmyCamp(int level) {
        ArmyCamp armyCamp = new ArmyCamp();
        armyCamp.setLevel(level);
        try {
            JSONObject army = armyCamp.loadConfig(level);
            armyCamp.setSize(army.getInt("height"));
            armyCamp.setHitPoints(army.getInt("hitpoints"));
            armyCamp.setCapacity(army.getInt("capacity"));
            armyCamp.setBuildingTime(army.getInt("buildTime"));
            armyCamp.setTownHallLevelRequired(army.getInt("townHallLevelRequired"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  armyCamp;
    }

    public GoldMine loadGoldMine(int level) {
        GoldMine goldMine = new GoldMine();
        goldMine.setLevel(level);
        try {
            JSONObject gold = goldMine.loadConfig(level);
            goldMine.setSize(gold.getInt("height"));
            goldMine.setHitPoints(gold.getInt("hitpoints"));
            goldMine.setCapacity(gold.getInt("capacity"));
            goldMine.setBuildingTime(gold.getInt("buildTime"));
            goldMine.setProductivity(gold.getInt("productivity"));
            goldMine.setTownHallLevelRequired(gold.getInt("townHallLevelRequired"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  goldMine;
    }

    public StaticObject loadStaticObject(String type) {
        StaticObject staticObject = new StaticObject(type);
        try {
            JSONObject staticObj = staticObject.loadConfig();
            staticObject.setSize(staticObj.getInt("height"));
            staticObject.setRemovedTime(staticObj.getInt("buildTime"));
            staticObject.setValue(staticObj.getInt("exp"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return staticObject;
    }

    public BuilderHut loadBuilderHut(int level) {
        BuilderHut builderHut = new BuilderHut();
        builderHut.setLevel(level);
        try {
            JSONObject builder = builderHut.loadConfig(level);
            builderHut.setSize(builder.getInt("height"));
            builderHut.setHitPoints(builder.getInt("hitpoints"));
            builderHut.setCoin(builder.getInt("coin"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builderHut;
    }

    public ClanCastle loadClanCastle(int level) {
        ClanCastle clanCastle = new ClanCastle();
        clanCastle.setLevel(level);
        try {
            JSONObject castle = clanCastle.loadConfig(level);
            clanCastle.setSize(castle.getInt("height"));
            clanCastle.setHitPoints(castle.getInt("hitpoints"));
            clanCastle.setTownHallLevelRequired(castle.getInt("townHallLevelRequired"));
            clanCastle.setBuildingTime(castle.getInt("buildTime"));
            clanCastle.setRange(castle.getInt("range"));
            clanCastle.setTroopCapacity(castle.getInt("troopCapacity"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clanCastle;
    }

    public Barrack loadBarrack(int level) {
        Barrack barrack = new Barrack();
        barrack.setLevel(level);
        JSONObject barrackJson = barrack.loadConfig(level);
        System.out.println(barrackJson);
        Gson gson = new Gson();
        barrack = gson.fromJson(barrackJson.toString(), Barrack.class);
        return  barrack;
    }

}
