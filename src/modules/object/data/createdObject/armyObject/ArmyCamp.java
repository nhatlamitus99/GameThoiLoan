package modules.object.data.createdObject.armyObject;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import modules.object.data.ObjectUtils;
import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArmyCamp extends CreatedObject {

    private final String TYPE_CATEGORY = "ArmyCamp";
    private final String TYPE_OBJECT = "AMC_1";


    public ArmyCamp() {
        this.setType(TYPE_CATEGORY);
        this.setTypeObj(TYPE_OBJECT);
    }

    public JSONObject loadConfig(int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, TYPE_OBJECT, level);
    }

    public String getTYPE_CATEGORY() {
        return TYPE_CATEGORY;
    }

    public String getTYPE_OBJECT() {
        return TYPE_OBJECT;
    }
}
