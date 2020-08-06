package modules.object.data.createdObject.warehouseObject;

import modules.object.data.ObjectUtils;
import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class GoldStorage extends CreatedObject {

    private final String TYPE_OBJECT = "STO_1";

    public GoldStorage() {
        this.setType("GoldStorage");
    }

    public JSONObject loadConfig(int level) {
        StorageUtils storageUtils = new StorageUtils();
        return storageUtils.loadConfig(TYPE_OBJECT, level);
    }
}
