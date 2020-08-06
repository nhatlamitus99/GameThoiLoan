package modules.object.data.createdObject;

import modules.object.data.ObjectUtils;
import org.json.JSONObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class BuilderHut extends CreatedObject {

    private final String TYPE_OBJECT = "BDH_1";
    private final String TYPE_CATEGORY = "BuilderHut";

    public BuilderHut() {
        this.setType("BuilderHut");
    }

    public JSONObject loadConfig(int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, TYPE_OBJECT, level);
    }
}
