package Adventure_Game;

import java.util.Scanner;

public class Player {
    private int damage;
    private int orjinalHealth;
    private int health;
    private int money;
    private String name;
    private int charID;
    private String charName;
    Inventory inventory = new Inventory();
    Scanner scan = new Scanner(System.in);


    public Player(String playerName, int charID) {
        this.name = playerName;
        this.charID = charID;
        selectChar(charID);

    }
    
  

    public void selectChar(int charID){
        switch(charID){
            case 1 :
                this.damage=5;
                this.health=21;
                this.money=15;
                this.orjinalHealth=health;
                this.charName="Samuray";
                break;
            case 2 :
                this.damage=7;
                this.health=18;
                this.money=20;
                this.orjinalHealth=health;
                this.charName="Okcu";
                break;
            case 3 :
                this.damage=8;
                this.health=24;
                this.money=5;
                this.orjinalHealth=health;
                this.charName="Sovalye";
                break;
            default:
                this.damage=5;
                this.health=21;
                this.money=15;
                this.orjinalHealth=health;
                this.charName="Samuray";
                break;

        }
    }

    public void characterInfo(){
        System.out.println("Karakter Bilgileri :\n"+
                "Karakter: " + this.charName +
                ", Silah:"+this.inventory.getWeaponName()+
                ", Silah Damage: "+ this.damage+
                ", Zırh Blokaj: " + this.inventory.getArmorBlockPower()+
                ", Sağlık: "+this.health+ ", "+
                ", Bütçe: "+this.money
        );
    }





    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        while(true) {
            if (charID < 0 && charID > 3) {
                System.out.println("Lütfen Geçerli Bir Character ID giriniz: ");
            }else{
               this.charID = charID;
            }
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            this.health=0;
        }else{
            this.health = health;
        }

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {

        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }




}
