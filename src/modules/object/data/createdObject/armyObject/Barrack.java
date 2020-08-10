package modules.object.data.createdObject.armyObject;

import modules.object.data.ObjectUtils;
import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class Barrack extends CreatedObject {


    private final String TYPE_CATEGORY = "Barrack";
    private final String TYPE_OBJECT = "BAR_1";
    int queueLength;


    public Barrack() {
        this.setType(TYPE_CATEGORY);
        this.setTypeObj(TYPE_OBJECT);
    }

    public String getTYPE_CATEGORY() {
        return TYPE_CATEGORY;
    }

    public String getTYPE_OBJECT() {
        return TYPE_OBJECT;
    }


    public JSONObject loadConfig(int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, TYPE_OBJECT, level);
    }


    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }
}
