package modules.object.data.staticObject;

import modules.object.data.MapObject;
import modules.object.data.ObjectUtils;
import org.json.JSONObject;

public class StaticObject extends MapObject {

    String TYPE_OBJECT;
    int removedTime;
    int value;

    private final String TYPE_CATEGORY = "Obstacle";

    public StaticObject(String TYPE_OBJECT) {
        this.setType("StaticObject");
        this.setTypeObstacle(TYPE_OBJECT);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



    public int getRemovedTime() {
        return removedTime;
    }

    public void setRemovedTime(int removedTime) {
        this.removedTime = removedTime;
    }

    public String getTypeObstacle() {
        return TYPE_OBJECT;
    }

    public void setTypeObstacle(String  typeObstacle) {
        this.TYPE_OBJECT = typeObstacle;
    }


    public JSONObject loadConfig() {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, this.getTypeObstacle(), 1);
    }
}
