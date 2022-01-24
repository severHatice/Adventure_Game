package Adventure_Game;

public class Weapon {

    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
        weaponSelection(id);
    }

    public void weaponSelection(int id){
        switch(id){
            case 1:
                this.id=id;
                this.name="Tabanca";
                this.damage=2;
                this.price=25;
                break;
            case 2:
                this.id=id;
                this.name="Kılıç";
                this.damage=3;
                this.price=35;
                break;
            case 3:
                this.id=id;
                this.name="Tüfek";
                this.damage=7;
                this.price=45;
                break;
            default:
                this.id=0;
                this.name="Yumruk";
                this.damage=1;
                this.price=0;
                break;
        }

    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


