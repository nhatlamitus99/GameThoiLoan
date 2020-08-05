package modules.object.data.createdObject;

import modules.object.data.MapObject;

public class CreatedObject extends MapObject {

    private int type;
    private int id;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
