package modules.object.data.createdObject.defenseObject;

import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class Canon extends CreatedObject {

    private final String TYPE_OBJECT = "DEF_1";

    public Canon() {
        this.setTypeId(4);
    }

    public JSONObject loadConfig() {
        DefenseUtils defenseUtils = new DefenseUtils();
        return defenseUtils.loadBaseConfig(TYPE_OBJECT);
    }

    public JSONObject loadDetailConfig(int level) {
        DefenseUtils defenseUtils = new DefenseUtils();
        return  defenseUtils.loadDetailConfig(TYPE_OBJECT, level);
    }
}
