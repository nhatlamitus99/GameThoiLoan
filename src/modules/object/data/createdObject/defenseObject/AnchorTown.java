package modules.object.data.createdObject.defenseObject;

import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class AnchorTown extends DefenseObject {

    private final String TYPE_OBJECT = "DEF_2";

    public AnchorTown() {
        this.setType("AnchorTown");
    }

    public JSONObject loadBaseConfig() {
        DefenseUtils defenseUtils = new DefenseUtils();
        return defenseUtils.loadBaseConfig(TYPE_OBJECT);
    }

    public JSONObject loadDetailConfig(int level) {
        DefenseUtils defenseUtils = new DefenseUtils();
        return  defenseUtils.loadDetailConfig(TYPE_OBJECT, level);
    }

}

