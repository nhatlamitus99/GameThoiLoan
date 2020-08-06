package modules.object;

import modules.object.data.MapObject;
import util.database.DataModel;

import java.awt.*;
import java.util.ArrayList;


public class ObjectMgr extends DataModel {
    private static final int numType = 12;
    public static final int numStaticObject = 5;
    private ArrayList<MapObject>[] listObject;

    public ObjectMgr() {
        super();
        listObject = new ArrayList[numType + 1];
    }

    public void addObject(MapObject object) {

        object.setId(listObject[object.getTypeId()].size());
        listObject[object.getTypeId()].add(object);
    }

    public ArrayList<MapObject>[] getListObject() {
        return listObject;
    }

    public MapObject getObject(int type, int id) {
        return listObject[type].get(id);

    }


}
