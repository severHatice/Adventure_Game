package Adventure_Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BattleLoc extends Location {


    private Monster monster;
    private String award;
    static List<Monster> monsters = new ArrayList<>();

    public BattleLoc(Player player, String LocName, Monster monster) {
        super(player, LocName);
        this.monster = monster;

    }

    @Override
    public boolean onLocatin(){
        System.out.println("<D>övüş yada <K>aç \nKaçarsanız 5Tl Ceza Kesilir.");
        String choiceFightorRun = scan.nextLine().toUpperCase();
        switch (choiceFightorRun){
            case "D":
                return combat();
            case "K":
                this.getPlayer().setMoney(this.getPlayer().getMoney()-5);
                System.out.println("Bütçenize 5TL Ceza Yansıtıldı\nYeni Bütçeniz: "+this.getPlayer().getMoney());
        }
        return true;
    }

    public boolean combat(){
        for(int i = 0; i < monsters.size(); i++){
            int counter=0;
            boolean isFinish = false;
            while(true){
                adjustBlockPower(i);
                int whoKick = rand.nextInt(2)+1;
                if(this.getPlayer().getHealth()>0 && whoKick==1){
                    System.out.println(this.getPlayer().getCharName()+ " Vurdu;");
                    monsters.get(i).setHealth(monsters.get(i).getHealth()-this.getPlayer().getDamage());
                    printSituation(i);
                    if(monsters.get(i).getHealth() ==0){
                        System.out.println("Sonuç : ");
                        System.out.println((i+1)+ ". "+monsters.get(i).getName()+" Yok Edildi.");
                        printSituation(i);
                        monsters.get(i).setHealth(monsters.get(i).getOrjinalHealth());
                        counter++;
                        //isFinish=true;
                        break;
                    }
                }

                if(monsters.get(i).getHealth()>0 && whoKick==2){
                    System.out.println(monsters.get(i).getName()+ " Vurdu;");
                    this.getPlayer().setHealth(this.getPlayer().getHealth()-monsters.get(i).getDamage());
                    printSituation(i);
                    if(this.getPlayer().getHealth()==0) {
                        System.out.println("Sonuç : ");
                        printSituation(i);
                        isFinish=true;
                        break;
                    }
                }
            }if(isFinish==true || counter == monsters.size()) {
                break;
            }
        }

        monsters.clear();
        return isWinChapter();
    }

    public void createMonsters(Monster monster){
        int num = rand.nextInt(3)+1;
        if(monster.getName().equals("Yılan")){
            num=rand.nextInt(5)+1;
        }
        for (int i = 0; i < num; i++) {
            monsters.add(monster);
        }
        monster.monsterInfo(monster, num);
        this.getPlayer().characterInfo();
        System.out.println("------------------------------------");

    }

    public void printSituation(int i){
        System.out.println(this.getPlayer().getCharName()+ " Health: "+ this.getPlayer().getHealth() +
                "\n"+monsters.get(i).getName()+ " Health: " + monsters.get(i).getHealth());
        System.out.println("---------------------------------------");

    }

    public boolean isWinChapter() {
        if (this.getPlayer().getHealth() > 0 && !this.getLocName().equals("Maden")) {
            //monsters.clear();
            System.out.println(this.getPlayer().getName() + " " + this.getLocName() + " Bölümünü Kazandınız" +
                    "\nÖdülünüz: " + this.getMonster().getAward());
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMoney());
            System.out.println("Yeni Bütçe: " + this.getPlayer().getMoney());
            switch (monster.getName()) {
                case "Zombi":
                    this.getPlayer().inventory.setFood(true);
                    break;
                case "Vampir":
                    this.getPlayer().inventory.setFireWood(true);
                    break;
                case "Ayı":
                    this.getPlayer().inventory.setWater(true);
                    break;
            }
            return true;

        }else if(this.getPlayer().getHealth() > 0 && this.getLocName().equals("Maden")){
            //monsters.clear();
            mineAreaAward();
            return true;
        }
        return false;
    }

    public void mineAreaAward(){
        int chance = rand.nextInt(100)+1;
        if(chance >0 && chance <=15){
            int chanceWeapon = rand.nextInt(100)+1;
            if(chanceWeapon > 0 && chanceWeapon <= 20){
                System.out.println("Tüfek Kazandınız: \nMevcut Silahınız İle Değiştirmek İstermisiniz <E> / <H>");
                this.getPlayer().characterInfo();
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("E")){
                    this.getPlayer().inventory.setWeaponName("Tüfek");
                    this.getPlayer().inventory.setWeaponDamage(7);
                }else{
                    System.out.println("Tabii Mantıklı Mevcut Silahınız: "
                            +this.getPlayer().inventory.getWeaponName() + " :)");
                }
            }else if(chanceWeapon > 20 && chanceWeapon <= 50){
                System.out.println("Kılıç Kazandınız: \nMevcut Silahınız İle Değiştirmek İstermisiniz <E> / <H>");
                this.getPlayer().characterInfo();
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("E")){
                    this.getPlayer().inventory.setWeaponName("Kılıç");
                    this.getPlayer().inventory.setWeaponDamage(3);
                }else{
                    System.out.println("Tabii Mantıklı Mevcut Silahınız: "
                            +this.getPlayer().inventory.getWeaponName() + " :)");
                }

            }else if(chanceWeapon > 50 && chanceWeapon <= 100){
                System.out.println("Tabanca Kazandınız: \nMevcut Silahınız İle Değiştirmek İstermisiniz <E> / <H>");
                this.getPlayer().characterInfo();
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("E")){
                    this.getPlayer().inventory.setWeaponName("Tabanca");
                    this.getPlayer().inventory.setWeaponDamage(2);
                }else{
                    System.out.println("Tabii Mantıklı Mevcut Silahınız: \n"
                            +this.getPlayer().inventory.getWeaponName() + " Daha İyi :)");
                }
            }


        }else if(chance >15 && chance <=30){
            int chanceArmor = rand.nextInt(100)+1;
            if(chanceArmor>0 && chanceArmor<= 50){
                System.out.println("Hafif Zırh Kazandınız: \nMevcut Zırhınız İle Değiştirmek İstermisiniz <E> / <H>");
                this.getPlayer().characterInfo();
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("E")){
                    this.getPlayer().inventory.setArmorName("Hafif");
                    this.getPlayer().inventory.setArmorBlockPower(1);
                }else{
                    System.out.println("Tabii Mantıklı Mevcut Zırhınız: "
                            +this.getPlayer().inventory.getArmorName()+ " Daha İyi :)");
                }

            }else if(chanceArmor>50 && chanceArmor<= 80){
                System.out.println("Orta Zırh Kazandınız: \nMevcut Zırhınız İle Değiştirmek İstermisiniz <E> / <H>");
                this.getPlayer().characterInfo();
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("E")){
                    this.getPlayer().inventory.setArmorName("Orta");
                    this.getPlayer().inventory.setArmorBlockPower(3);
                }else{
                    System.out.println("Tabii Mantıklı Mevcut Zırhınız: "
                            +this.getPlayer().inventory.getArmorName()+ " Daha İyi :)");
                }

            }else if(chanceArmor>80 && chanceArmor<= 100){
                System.out.println("Ağır Zırh Kazandınız: \nMevcut Zırhınız İle Değiştirmek İstermisiniz <E> / <H>");
                this.getPlayer().characterInfo();
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("E")){
                    this.getPlayer().inventory.setArmorName("Ağır");
                    this.getPlayer().inventory.setArmorBlockPower(1);
                }else{
                    System.out.println("Tabii Mantıklı Mevcut Zırhınız: "
                            +this.getPlayer().inventory.getArmorName()+ " Daha İyi :)");
                }

            }

        }else if(chance >30 && chance <=55){
            int chanceMoney = rand.nextInt(100)+1;
            if(chanceMoney>0 && chanceMoney<= 20){
                System.out.println("10TL Kazandınız" );
                this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
                System.out.println("Paranız Kasaya Eklendi \nYeni Bütçeniz: "+this.getPlayer().getMoney()+"TL");

            }if(chanceMoney>20 && chanceMoney<= 50){
                System.out.println("5TL Kazandınız" );
                this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
                System.out.println("Paranız Kasaya Eklendi \nYeni Bütçeniz: "+this.getPlayer().getMoney()+"TL");

            }if(chanceMoney>50 && chanceMoney<= 100){
                System.out.println("1TL Kazandınız" );
                this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
                System.out.println("Paranız Kasaya Eklendi \nYeni Bütçeniz: "+this.getPlayer().getMoney()+"TL");

            }

        }else if(chance >55 && chance <=100){
            System.out.println("Çok Şanssızsın Seni Eli Boş Gönderiyoruz");
        }
    }

    public void adjustBlockPower(int i){
        if(this.getPlayer().inventory.getArmorBlockPower() < monsters.get(i).getDamage()){
            monsters.get(i).setDamage(monsters.get(i).getDamage()-this.getPlayer().inventory.getArmorBlockPower());
        }else{
            monsters.get(i).setDamage(0);
        }
    }



    ///// GETTER - SETTER ///////

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }







}
