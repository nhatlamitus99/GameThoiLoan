package modules.object.data.createdObject.defenseObject;

import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class Trebuchet extends DefenseObject {

    public String getTYPE_OBJECT() {
        return TYPE_OBJECT;
    }

    private final String TYPE_OBJECT = "DEF_3";

    public Trebuchet() {
        this.setType(this.getTYPE_CATEGORY());
        this.setTypeObj(TYPE_OBJECT);
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
