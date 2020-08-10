package model;

import java.awt.Point;

import cmd.obj.demo.DemoDirection;
import cmd.obj.demo.MaxPosition;
import util.database.DataModel;

public class PlayerInfo extends DataModel {
    // Zing me
    private int id;
    private String name;
    public Point position;

    public PlayerInfo(int _id, String _name) {
        super();
        id = _id;
        name = _name;
        position = new Point(0, 0);
    }

    public String toString() {
        return String.format("%s|%s", new Object[] { id, name });
    }

    public String getName(){
        return this.name;
    }

    public String setName(String name){
        this.name = name;
        return this.getName();
    }
}
