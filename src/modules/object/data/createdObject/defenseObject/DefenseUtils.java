package modules.object.data.createdObject.defenseObject;

import modules.object.data.ObjectUtils;
import org.json.JSONObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class DefenseUtils {

    private final String TYPE_CATEGORY = "DefenceBase";
    private final String TYPE_DETAIL_CATEGORY = "Defence";

    public JSONObject loadBaseConfig(String typeObject) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadBaseConfig(TYPE_CATEGORY, typeObject);
    }

    public JSONObject loadDetailConfig(String typeObject, int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_DETAIL_CATEGORY, typeObject, level);
    }
}

