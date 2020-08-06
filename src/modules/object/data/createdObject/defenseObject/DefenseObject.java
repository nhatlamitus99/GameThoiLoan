package modules.object.data.createdObject.defenseObject;

import modules.object.data.createdObject.CreatedObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class DefenseObject extends CreatedObject {
    int minRange;
    int maxRange;
    int attackSpeed;
    int attackRadius;
    int attackArea;
    int attackType;

    public int getMinRange() {
        return minRange;
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getAttackRadius() {
        return attackRadius;
    }

    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    public int getAttackArea() {
        return attackArea;
    }

    public void setAttackArea(int attackArea) {
        this.attackArea = attackArea;
    }

    public int getAttackType() {
        return attackType;
    }

    public void setAttackType(int attackType) {
        this.attackType = attackType;
    }
}
