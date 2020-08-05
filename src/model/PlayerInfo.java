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
    
    public Point move(short direction){        
        if (direction == DemoDirection.UP.getValue()){
            position.x++;
        }
        else if (direction == DemoDirection.DOWN.getValue()){
            position.x--;
        }
        else if (direction == DemoDirection.RIGHT.getValue()){
            position.y++;
        }
        else{
            position.y--;
        }
        
        position.x = position.x % MaxPosition.X;
        position.y = position.y % MaxPosition.Y;
                
        return position;
    }

    public String getName(){
        return name;
    }

    public String setName(String name){
        this.name = name;
        return this.getName();
    }
}
