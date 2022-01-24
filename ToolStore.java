package Adventure_Game;

public class ToolStore extends NormalLoc{

    public ToolStore(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocatin() {


        while(true){
            System.out.println("Dükkan Seçin: \n1. Silah Dükkanı\n2. Zırh Dükkanı \n0. Çıkış");
            int store = scan.nextInt();
            switch(store) {
                case 1:
                    store=buyWeapon();
                    break;
                case 2:
                    store=buyArmor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Geçerli bir işlem siçin");
                    break;

            }
            if(store == 0){
                break;
            }
        }return true;
    }





    public int buyArmor(){
        System.out.println("ZIRHLAR :");
        Armor [] armors = {
                new Armor(1),
                new Armor(2),
                new Armor(3)
        };
        for(Armor armor : armors){
            System.out.println("ID: "+ armor.getId()+" Zırh :"+armor.getName()+ " Blok Gücü: "+armor.getBlokPower()+ " Para: "+armor.getPrice());
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Almak İstdeğiniz Zırhın ID'sini Girin:\nÇıkış İçin 0' Basın:");
        int armorSelection = scan.nextInt();
        if(armorSelection==0) return 2;
        Armor armor = new Armor(armorSelection);
        if(this.getPlayer().getMoney() >= armor.getPrice()){
            this.getPlayer().inventory.setArmorName(armor.getName());
            this.getPlayer().inventory.setArmorBlockPower(armor.getBlokPower());

        }else{
            System.out.println("Bütçeniz: "+ this.getPlayer().getMoney() + "TL, " +
                    "\nalmak istediğiniz silah: "+ armor.getPrice()+"TL \nBütçeniz Yetersiz.");
            System.out.println("----------------------------------------------------------------------");
        }

        this.getPlayer().characterInfo();
        return 2;
    }

    public int buyWeapon(){
        System.out.println("SİLAHLAR :");
        Weapon [] weapons = {
                new Weapon(1),
                new Weapon(2),
                new Weapon(3)
        };
        for(Weapon weapon : weapons){
            System.out.println("ID: "+ weapon.getId()+" Silah :"+weapon.getName()+ " Hasar: "+weapon.getDamage()+ " Para: "+weapon.getPrice());
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Almak İstdeğiniz Silah ID'sini Girin:\nÇıkış İçin 0' Basın:\"");
        int weaponSelection = scan.nextInt();
        if(weaponSelection==0) return 1;
        Weapon silah = new Weapon(weaponSelection);
        if(this.getPlayer().getMoney() >= silah.getPrice()){
            this.getPlayer().inventory.setWeaponName(silah.getName());
            this.getPlayer().inventory.setWeaponDamage(silah.getDamage());
            this.getPlayer().setDamage(this.getPlayer().getDamage()+ getPlayer().inventory.getWeaponDamage());
            this.getPlayer().setMoney(this.getPlayer().getMoney()-silah.getPrice());
            this.getPlayer().characterInfo();

        }else{
            System.out.println("Bütçeniz: "+ this.getPlayer().getMoney() + "TL, " +
                    "\nalmak istediğiniz silah: "+ silah.getPrice()+"TL \nBütçeniz Yetersiz.");
            System.out.println("----------------------------------------------------------------------");
        }return 1;
    }
}
