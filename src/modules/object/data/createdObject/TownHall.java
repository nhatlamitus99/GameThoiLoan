package modules.object.data.createdObject;

import modules.object.data.ObjectUtils;
import org.json.JSONObject;

public class TownHall extends CreatedObject {

    private final String TYPE_OBJECT = "TOW_1";
    private final String TYPE_CATEGORY = "TownHall";

    public int getCapacityGold() {
        return capacityGold;
    }

    public void setCapacityGold(int capacityGold) {
        this.capacityGold = capacityGold;
    }

    public int getCapacityElixir() {
        return capacityElixir;
    }

    public void setCapacityElixir(int capacityElixir) {
        this.capacityElixir = capacityElixir;
    }

    int capacityGold;
    int capacityElixir;

    public TownHall() {
        this.setType("TownHall");
    }

    public JSONObject loadConfig(int level) {
        ObjectUtils objectUtils = new ObjectUtils();
        return objectUtils.loadConfig(TYPE_CATEGORY, TYPE_OBJECT, level);
    }
}
