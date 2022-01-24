package Adventure_Game;

import java.util.Random;
import java.util.Scanner;

public abstract class Location {

    private Player player;
    private String LocName="";
    protected Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public Location(Player player, String LocName) {
        this.player = player;
        this.LocName = LocName;
    }

    public Location() {

    }

    abstract boolean onLocatin();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocName() {
        return LocName;
    }

    public void setLocName(String locName) {
        LocName = locName;
    }
}

