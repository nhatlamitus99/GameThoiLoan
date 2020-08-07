package modules.object.data.staticObject;

import modules.object.data.MapObject;
import modules.object.data.ObjectUtils;
import org.json.JSONObject;

public class StaticObject extends MapObject {


    int removedTime;
    int value;
    private final String TYPE_CATEGORY = "Obstacle";

    public StaticObject(String TYPE_OBJECT) {
        this.setType(TYPE_CATEGORY);
        this.setTypeObj(TYPE_OBJECT);
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



    public JSONObject loadConfig() {
        ObjectUtils objectUtils = new ObjectUtils();
        this.setLevel(1);
        return objectUtils.loadConfig(TYPE_CATEGORY, this.getTypeObj(), 1);
    }
}
