package Adventure_Game;

public class SafeHouse extends NormalLoc {


    public SafeHouse(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocatin() {
        System.out.println(this.getPlayer().getName()+ " " + this.getPlayer().getCharName() + " olarak Şu anda Güvenli Evdesiniz Canınız Yenilendi.:");

        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());

        this.getPlayer().characterInfo();

        return true;
    }




}
