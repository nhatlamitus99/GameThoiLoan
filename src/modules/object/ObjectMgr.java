package modules.object;

import modules.map.data.Map;
import modules.object.data.MapObject;
import modules.object.data.createdObject.TownHall;
import modules.object.data.createdObject.armyObject.ArmyCamp;
import modules.object.data.createdObject.harvestObject.GoldMine;
import modules.object.data.staticObject.StaticObject;
import org.json.JSONException;
import org.json.JSONObject;
import util.database.DataModel;

import java.awt.*;
import java.util.*;
import java.util.List;


public class ObjectMgr extends DataModel {
    public static final int NUM_STATIC_OBJECT = 5;
    private HashMap<String, ArrayList<MapObject>> listObject;

    public ObjectMgr() {
        super();
        listObject = new HashMap<String, ArrayList<MapObject>>();
    }

    public void addObject(MapObject object) {

        if(listObject.containsKey(object.getType())) {
            listObject.get(object.getType()).add(object);
        }
        else {
            ArrayList<MapObject> list = new ArrayList<MapObject>();
            list.add(object);
            listObject.put(object.getType(), list);
        }

        System.out.println("id:" + listObject.get(object.getType()).size());
        object.setId(listObject.get(object.getType()).size());

    }

    public HashMap<String, ArrayList<MapObject>> getListObject() {
        return listObject;
    }

    public MapObject getObject(String type, int id) {
        return listObject.get(type).get(id - 1);

    }

    public TownHall loadTownHall(int level) {
        TownHall townHall = new TownHall();
        try {
            JSONObject hall = townHall.loadConfig(1);
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
        try {
            JSONObject army = armyCamp.loadConfig(1);
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
        try {
            JSONObject gold = goldMine.loadConfig(1);
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

    public StaticObject loadStaticObject(int type) {
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

}
