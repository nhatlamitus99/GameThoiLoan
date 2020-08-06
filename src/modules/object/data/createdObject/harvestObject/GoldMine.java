package modules.object.data.createdObject.harvestObject;

import modules.object.data.createdObject.CreatedObject;
import modules.object.data.createdObject.warehouseObject.StorageUtils;
import org.json.JSONObject;

public class GoldMine extends CreatedObject {

    private final String TYPE_OBJECT = "RES_1";

    public GoldMine() {
        this.setTypeId(7);
    }

    public JSONObject loadConfig(int level) {
        MineUtils mineUtils = new MineUtils();
        return mineUtils.loadConfig(TYPE_OBJECT, level);
    }
}
