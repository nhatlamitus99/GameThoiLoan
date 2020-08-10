package modules.object.data.createdObject.warehouseObject;

import modules.object.data.ObjectUtils;
import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class GoldStorage extends CreatedObject {

    private final String TYPE_OBJECT = "STO_1";
    private final String TYPE_CATEGORY = "Storage";


    public GoldStorage() {
        this.setTypeObj(TYPE_OBJECT);
        this.setType(TYPE_CATEGORY);
    }

    public JSONObject loadConfig(int level) {
        StorageUtils storageUtils = new StorageUtils();
        return storageUtils.loadConfig(TYPE_OBJECT, level);
    }
}
