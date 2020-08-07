package modules.object.data.createdObject;

import modules.object.data.ObjectUtils;
import org.json.JSONObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class ClanCastle extends CreatedObject {

    private final String TYPE_OBJECT = "CLC_1";
    private final String TYPE_CATEGORY = "ClanCastle";

    public int getTroopCapacity() {
        return troopCapacity;
    }

    public void setTroopCapacity(int troopCapacity) {
        this.troopCapacity = troopCapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    int troopCapacity;
    int range;
    // Resource cost

    public ClanCastle() {
        this.setType("ClanCastle");
    }

    public JSONObject loadConfig(int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, TYPE_OBJECT, level);
    }
}
