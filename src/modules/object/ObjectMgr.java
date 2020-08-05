package modules.object;

import modules.object.data.MapObject;
import util.database.DataModel;


public class ObjectMgr extends DataModel {
    private static final int numType = 11;
    public static final int numStaticObject = 5;
    private Object[] listObject;

    public ObjectMgr() {
        super();
        listObject = new Object[numType + 1];
    }

    public void addObject(MapObject object) {
        listObject[object.getType()] = object;
    }

    public Object[] getListObject() {
        return listObject;
    }


}
