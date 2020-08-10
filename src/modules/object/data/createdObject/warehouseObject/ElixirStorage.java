package modules.object.data.createdObject.warehouseObject;

import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class ElixirStorage extends CreatedObject {

    private final String TYPE_OBJECT = "STO_2";
    private final String TYPE_CATEGORY = "Storage";


    public ElixirStorage() {
        this.setTypeObj(TYPE_OBJECT);
        this.setType(TYPE_CATEGORY);
    }

    public JSONObject loadConfig(int level) {
        StorageUtils storageUtils = new StorageUtils();
        return storageUtils.loadConfig(TYPE_OBJECT, level);
    }
}
