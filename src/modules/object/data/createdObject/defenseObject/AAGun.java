package modules.object.data.createdObject.defenseObject;

import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class AAGun extends CreatedObject {

    private final String TYPE_OBJECT = "DEF_5";

    public AAGun() {
        this.setTypeId(12);
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
