package modules.object.data;


import modules.game.data.Resource;
import util.database.DataModel;
import java.awt.*;
import java.util.Date;

public class MapObject extends DataModel {

    int typeId;
    String type;
    String typeObj;
    int level;
    String name;
    int size;
    int id;
    Point position;
    boolean state;
    String imagePath;
    Date beginTime;
    Resource cost = new Resource(0, 0, 0);

    public Resource getCost() {
        return cost;
    }

    public void setCost(int gold, int elixir) {
        this.cost.setGold(gold);
        this.cost.setElixir(elixir);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public String getTypeObj() {
        return typeObj;
    }

    public void setTypeObj(String typeObj) {
        this.typeObj = typeObj;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
