package modules.map.data;


public class Map {
    private static final int SIZE_MAP = 40;
    private Pair[][] map;

    Map(){
        map = new Pair[SIZE_MAP][SIZE_MAP];
        for(int i=0; i < SIZE_MAP; i++) {
            for(int j=0; j < SIZE_MAP; j++) {
                map[i][j].type = -1;
                map[i][j].id = -1;
            }
        }
    }

}
