package modules.game.data;

import model.PlayerInfo;
import modules.object.ObjectData;
import modules.object.ObjectMgr;
import modules.object.data.MapObject;
import util.database.DataModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CPU12750-local on 8/7/2020.
 */
public class GameData extends DataModel implements Cloneable {
    Resource resource;
    PlayerInfo playerInfo;
    ArrayList<ObjectData> listObject = new ArrayList<ObjectData>();

    public void loadResource(Resource res) {
        resource = res;
    }

    public void loadPlayerInfo(PlayerInfo player) {
        playerInfo = player;
    }

    public void loadMapObject(ObjectMgr objectMgr){

        for (ArrayList<MapObject> list : objectMgr.getListObject().values()) {
            for(int i=0; i < list.size(); i++) {
                ObjectData objectData = new ObjectData();
                objectData.setTypeCategory(list.get(i).getType());
                objectData.setTypeObject(list.get(i).getTypeObj());
                objectData.setLevel(list.get(i).getLevel());
                objectData.setId(list.get(i).getId());
                objectData.setPosition(list.get(i).getPosition());
                objectData.setCurrentTime(new Date());
                listObject.add(objectData);
            }
        }
    }

    public GameData clone()throws CloneNotSupportedException{
        return (GameData)super.clone();
    }
}
