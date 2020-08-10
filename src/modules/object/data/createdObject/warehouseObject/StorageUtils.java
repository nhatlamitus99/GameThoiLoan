package modules.object.data.createdObject.warehouseObject;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import modules.object.ObjectMgr;
import modules.object.data.MapObject;
import modules.object.data.ObjectUtils;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPU12750-local on 8/6/2020.
 */

public class StorageUtils {

    public final String TYPE_CATEGORY = "Storage";

    public JSONObject loadConfig(String typeObject, int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, typeObject, level);
    }

}
