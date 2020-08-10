package modules.map.data;


import modules.object.data.MapObject;
import util.database.DataModel;

import java.awt.*;

public class Map extends DataModel {

    private static final int SIZE_MAP = 40;
    private Pair[][] map;

    public Map(){
        map = new Pair[SIZE_MAP][SIZE_MAP];
        for(int i=0; i < SIZE_MAP; ++i) {
            for(int j=0; j < SIZE_MAP; ++j) {
                map[i][j].type = -1;
                map[i][j].id = -1;
            }
        }
    }

    public boolean checkOverlap(MapObject object) {
        int x = object.getPosition().x;
        int y = object.getPosition().y;

        for(int i=x; i < x + object.getSize(); ++i) {
            for(int j=y; j < y + object.getSize(); ++j) {
                if(map[i][j].type != -1)
                    return false;
            }
        }
        return true;
    }
    
    public void insertObject(MapObject object) {
        map[object.getPosition().x][object.getPosition().y].type = object.getTypeId();
        map[object.getPosition().x][object.getPosition().y].id = object.getId();
    }

    public void moveObject(MapObject object, Point newPoint){
        map[object.getPosition().x][object.getPosition().y].type = newPoint.x;
        map[object.getPosition().x][object.getPosition().y].id = newPoint.y;
    }

    public void removeObject(MapObject object) {
        map[object.getPosition().x][object.getPosition().y].type = -1;
        map[object.getPosition().x][object.getPosition().y].id = -1;
    }

}
