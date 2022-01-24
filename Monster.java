package Adventure_Game;

import java.util.Random;

public abstract class Monster {

    String name;
    private int id;
    private int orjinalDamage;
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String award;
    Random rand = new Random();

    public Monster(int id) {
       this.id = id;
       createMonster(this.id);
    }


    public void createMonster(int id){
        switch(id){
            case 1:
                this.name = "Zombi";
                this.damage = 3;
                this.orjinalDamage = damage;
                this.health = 10;
                this.orjinalHealth=health;
                this.money = 4;
                this.award="Yemek";
                break;
            case 2:
                this.name = "Vampir";
                this.damage = 4;
                this.orjinalDamage = damage;
                this.health = 14;
                this.orjinalHealth=health;
                this.money = 7;
                this.award="Odun";
                break;
            case 3:
                this.name = "Ayı";
                this.damage = 7;
                this.orjinalDamage = damage;
                this.health = 20;
                this.orjinalHealth=health;
                this.money = 12;
                this.award="Su";
                break;
            case 4:
                int num = rand.nextInt(3)+3;
                this.name="Yılan";
                this.damage=num;
                this.orjinalDamage=damage;
                this.health=12;
                this.orjinalHealth=health;
                this.money=0;
                this.award="Sürpriz Hediyeler !!";
                break;
        }


    }

    public void monsterInfo(Monster monster, int num){
       System.out.println("Canavar Bilgileri: \n"+
               "Canavar Sayısı : "+num+", Cavavar: " + this.name +
               ", Hasar: "+ this.damage + ", Sağlık: "+ this.health + ", Money: "+ this.money + ", Ödül: "+ this.award);
    }


    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrjinalDamage() {
        return orjinalDamage;
    }

    public void setOrjinalDamage(int orjinalDamage) {
        this.orjinalDamage = orjinalDamage;
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
            this.health = 0;
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


}
