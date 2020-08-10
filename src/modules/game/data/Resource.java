package modules.game.data;

import util.database.DataModel;

public class Resource extends DataModel {


    private int gold;
    private int elixir;
    private int g;



    enum Type {
        GOLD,
        ELIXIR,
        G
    }

    public Resource(int GOLD, int ELIXIR, int G) {
        super();
        gold = GOLD;
        elixir = ELIXIR;
        g = G;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        System.out.println("gold");
        this.gold = gold;
    }

    public int getElixir() {
        return elixir;
    }

    public void setElixir(int elixir) {
        System.out.println("gold");
        this.elixir = elixir;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void increaseResource(Type type, int amount){
        switch (type) {
            case GOLD:
                this.setGold(this.getGold() + amount);
                break;
            case ELIXIR:
                this.setElixir(this.getElixir() + amount);
                break;
            case G:
                this.setG(this.getG() + amount);
                break;
        }
    }

    public void decreaseResource(Type type, int amount){
        switch (type) {
            case GOLD:
                this.setGold(this.getGold() - amount);
                break;
            case ELIXIR:
                this.setElixir(this.getElixir() - amount);
                break;
            case G:
                this.setG(this.getG() - amount);
                break;
        }
    }


}
