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
import modules.object.data.createdObject.defenseObject.AAGun;
import modules.object.data.createdObject.defenseObject.DefenseObject;
import modules.object.data.createdObject.harvestObject.ElixirMine;
import modules.object.data.createdObject.harvestObject.GoldMine;
import modules.object.data.createdObject.warehouseObject.ElixirStorage;
import modules.object.data.createdObject.warehouseObject.GoldStorage;
import modules.object.data.staticObject.StaticObject;
import org.json.JSONException;
import org.json.JSONObject;
import util.database.DataModel;

import java.awt.*;
import java.util.*;
import java.util.List;


public class ObjectMgr extends DataModel {

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

    public ElixirMine loadElixirMine(int level) {
        ElixirMine elixirMine = new ElixirMine();
        elixirMine.setLevel(level);
        try {
            JSONObject elixir = elixirMine.loadConfig(level);
            elixirMine.setSize(elixir.getInt("height"));
            elixirMine.setHitPoints(elixir.getInt("hitpoints"));
            elixirMine.setCapacity(elixir.getInt("capacity"));
            elixirMine.setBuildingTime(elixir.getInt("buildTime"));
            elixirMine.setProductivity(elixir.getInt("productivity"));
            elixirMine.setTownHallLevelRequired(elixir.getInt("townHallLevelRequired"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  elixirMine;
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
        try {
            JSONObject jsonBarrack = barrack.loadConfig(level);
            barrack.setSize(jsonBarrack.getInt("height"));
            barrack.setHitPoints(jsonBarrack.getInt("hitpoints"));
            barrack.setTownHallLevelRequired(jsonBarrack.getInt("townHallLevelRequired"));
            barrack.setBuildingTime(jsonBarrack.getInt("buildTime"));
            barrack.setCost(0, jsonBarrack.getInt("elixir"));
            barrack.setQueueLength(jsonBarrack.getInt("queueLength"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return barrack;
    }

    public GoldStorage loadGoldStorage(int level) {
        GoldStorage gold = new GoldStorage();
        gold.setLevel(level);
        try {
            JSONObject jsonGold = gold.loadConfig(level);
            gold.setCapacity(jsonGold.getInt("capacity"));
            gold.setSize(jsonGold.getInt("height"));
            gold.setHitPoints(jsonGold.getInt("hitpoints"));
            gold.setTownHallLevelRequired(jsonGold.getInt("townHallLevelRequired"));
            gold.setBuildingTime(jsonGold.getInt("buildTime"));
            gold.setCost(0, jsonGold.getInt("elixir"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gold;
    }

    public ElixirStorage loadElixirStorage(int level) {
        ElixirStorage elixir = new ElixirStorage();
        elixir.setLevel(level);
        try {
            JSONObject jsonElixir = elixir.loadConfig(level);
            elixir.setCapacity(jsonElixir.getInt("capacity"));
            elixir.setSize(jsonElixir.getInt("height"));
            elixir.setHitPoints(jsonElixir.getInt("hitpoints"));
            elixir.setTownHallLevelRequired(jsonElixir.getInt("townHallLevelRequired"));
            elixir.setBuildingTime(jsonElixir.getInt("buildTime"));
            elixir.setCost(0, jsonElixir.getInt("elixir"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return elixir;
    }

    public DefenseObject loadDefenceObject(String typeObject, int level) {
        DefenseObject defenseObject = DefenseObject.getInstance(typeObject);
        defenseObject.setLevel(level);
        try {
            JSONObject jsonGun = defenseObject.loadConfig(typeObject);
            JSONObject jsonDetailGun = defenseObject.loadDetailConfig(typeObject, level);

            defenseObject.setMinRange(jsonGun.getDouble("minRange"));
            defenseObject.setMaxRange(jsonGun.getDouble("maxRange"));
            defenseObject.setAttackSpeed(jsonGun.getDouble("attackSpeed"));
            defenseObject.setAttackRadius(jsonGun.getDouble("attackRadius"));
            defenseObject.setAttackArea(jsonGun.getInt("attackArea"));
            defenseObject.setAttackType(jsonGun.getInt("attackType"));
            defenseObject.setCost(jsonDetailGun.getInt("gold"), 0);
            defenseObject.setSize(jsonDetailGun.getInt("height"));
            defenseObject.setHitPoints(jsonDetailGun.getInt("hitpoints"));
            defenseObject.setTownHallLevelRequired(jsonDetailGun.getInt("townHallLevelRequired"));
            defenseObject.setBuildingTime(jsonDetailGun.getInt("buildTime"));
            defenseObject.setDamagePerSecond((jsonDetailGun.getInt("damagePerSecond")));
            defenseObject.setDamagePerShot((jsonDetailGun.getInt("damagePerShot")));


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return defenseObject;
    }

}
