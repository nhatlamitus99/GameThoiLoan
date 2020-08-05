package modules.game.data;

import util.database.DataModel;

public class Resource extends DataModel {

    private final int GOLD_INIT = 1000;
    private final int ELIXIR_INIT = 1000;
    private final int G_INIT = 100;


    private int gold;
    private int elixir;
    private int g;

    enum Type {
        GOLD,
        ELIXIR,
        G
    }

    Resource() {
        super();
        gold = GOLD_INIT;
        elixir = ELIXIR_INIT;
        g = G_INIT;
    }

    public int getGold() {
        return gold;
    }

    private void setGold(int gold) {
        this.gold = gold;
    }

    public int getElixir() {
        return elixir;
    }

    private void setElixir(int elixir) {
        this.elixir = elixir;
    }

    public int getG() {
        return g;
    }

    private void setG(int g) {
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
