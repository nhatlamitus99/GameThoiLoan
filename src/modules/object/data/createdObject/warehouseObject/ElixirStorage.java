package modules.object.data.createdObject.warehouseObject;

import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

public class ElixirStorage extends CreatedObject {

    private final String TYPE_OBJECT = "STO_2";


    public ElixirStorage() {
        this.setTypeId(8);
    }

    public JSONObject loadConfig(int level) {
        StorageUtils storageUtils = new StorageUtils();
        return storageUtils.loadConfig(TYPE_OBJECT, level);
    }
}
