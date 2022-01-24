package Adventure_Game;

public class Armor {
    private int id;
    private String name;
    private int blokPower;
    private int price;

    public Armor(int id){
        this.id=id;
        armorSelection(this.id);
    }

    public void armorSelection(int id){
        switch(id){
            case 1:
                this.id=id;
                this.name="Hafif";
                this.blokPower=1;
                this.price=25;
                break;
            case 2:
                this.id=id;
                this.name="Orta";
                this.blokPower=3;
                this.price=35;
                break;
            case 3:
                this.id=id;
                this.name="Ağır";
                this.blokPower=5;
                this.price=45;
                break;
            default:
                this.id=0;
                this.name="Yumruk";
                this.blokPower=0;
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

    public int getBlokPower() {
        return blokPower;
    }

    public void setBlokPower(int blokPower) {
        this.blokPower = blokPower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
