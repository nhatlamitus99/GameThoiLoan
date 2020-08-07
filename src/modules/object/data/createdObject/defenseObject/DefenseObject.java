package modules.object.data.createdObject.defenseObject;

import modules.game.data.Resource;
import modules.object.data.createdObject.CreatedObject;
import org.json.JSONObject;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class DefenseObject extends CreatedObject {

    private final String TYPE_CATEGORY = "Defence";

    double minRange;
    double maxRange;
    double attackSpeed;
    double attackRadius;
    int attackArea;
    int attackType;
    int damagePerSecond;
    int damagePerShot;


    public static DefenseObject getInstance(String typeObject) {
        DefenseObject defenseObject = null;
        switch (typeObject) {
            case "DEF_1": defenseObject = new Canon();
                break;
            case "DEF_2": defenseObject = new AnchorTown();
                break;
            case "DEF_3": defenseObject = new Trebuchet();
                break;
            case "DEF_5": defenseObject = new AAGun();
                break;
        }
        return defenseObject;
    }

    public JSONObject loadConfig(String typeObject) {
        DefenseUtils defenseUtils = new DefenseUtils();
        return defenseUtils.loadBaseConfig(typeObject);
    }

    public JSONObject loadDetailConfig(String typeObject, int level) {
        DefenseUtils defenseUtils = new DefenseUtils();
        return  defenseUtils.loadDetailConfig(typeObject, level);
    }


    public int getDamagePerSecond() {
        return damagePerSecond;
    }

    public void setDamagePerSecond(int damagePerSecond) {
        this.damagePerSecond = damagePerSecond;
    }

    public int getDamagePerShot() {
        return damagePerShot;
    }

    public void setDamagePerShot(int damagePerShot) {
        this.damagePerShot = damagePerShot;
    }


    public String getTYPE_CATEGORY() {
        return TYPE_CATEGORY;
    }

    public double getMinRange() {
        return minRange;
    }

    public void setMinRange(double minRange) {
        this.minRange = minRange;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getAttackRadius() {
        return attackRadius;
    }

    public void setAttackRadius(double attackRadius) {
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
