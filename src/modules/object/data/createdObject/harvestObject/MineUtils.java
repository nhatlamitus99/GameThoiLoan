package modules.object.data.createdObject.harvestObject;

import modules.object.data.ObjectUtils;
import org.json.JSONObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class MineUtils {

    private final String TYPE_CATEGORY = "Resource";

    public JSONObject loadConfig(String typeObject, int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, typeObject, level);
    }

}
