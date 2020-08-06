package modules.object.data.staticObject;

import modules.object.data.MapObject;
import modules.object.data.ObjectUtils;
import org.json.JSONObject;

public class StaticObject extends MapObject {

    private int typeObstacle;

    int removedTime;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private final String TYPE_CATEGORY = "Obstacle";

    public StaticObject(int typeObstacle) {
        this.setType("StaticObject");
        this.setTypeObstacle(typeObstacle);
    }

    public int getRemovedTime() {
        return removedTime;
    }

    public void setRemovedTime(int removedTime) {
        this.removedTime = removedTime;
    }

    public int getTypeObstacle() {
        return typeObstacle;
    }

    public void setTypeObstacle(int  typeObstacle) {
        this.typeObstacle = typeObstacle;
    }


    public JSONObject loadConfig() {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, "OBS_"+this.getTypeObstacle(), 1);
    }
}
