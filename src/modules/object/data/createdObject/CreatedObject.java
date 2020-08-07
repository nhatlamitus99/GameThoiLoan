package modules.object.data.createdObject;

import modules.object.data.MapObject;

import java.util.Date;

public class CreatedObject extends MapObject {

    int hitPoints;
    int buildingCost;
    int buildingTime;
    int upgradingCost;
    int upgradingTime;
    int hp;
    int value;
    int capacity;
    int productivity;

    public int getTownHallLevelRequired() {
        return townHallLevelRequired;
    }

    public void setTownHallLevelRequired(int townHallLevelRequired) {
        this.townHallLevelRequired = townHallLevelRequired;
    }

    int townHallLevelRequired = 0;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }



    public int getBuildingCost() {
        return buildingCost;
    }

    public void setBuildingCost(int buildingCost) {
        this.buildingCost = buildingCost;
    }

    public int getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(int buildingTime) {
        this.buildingTime = buildingTime;
    }

    public int getUpgradingCost() {
        return upgradingCost;
    }

    public void setUpgradingCost(int upgradingCost) {
        this.upgradingCost = upgradingCost;
    }

    public int getUpgradingTime() {
        return upgradingTime;
    }

    public void setUpgradingTime(int upgradingTime) {
        this.upgradingTime = upgradingTime;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }


}
