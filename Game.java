package Adventure_Game;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);
    Player player;
    Location location;
    static boolean isSafeHouse;


    public void start() {
        System.out.println("Macera Oyununa Hoş Geldiniz Bu Oyunda Yaşanacak Herşey Gerçektir !!!!");
        System.out.print("Lütfen Adınızı Giriniz:");
        String playerName = scan.nextLine();
        System.out.println("Sayın " + playerName + " Macerea Oyununa Hoşgeldiniz;");
        charSelection(playerName);

        System.out.println("----------------------------------------------------------------------");
        while (true) {
            System.out.println("Nereye Gitmek İstersiniz: \n1. Güvenli Ev\n2. Araç Dükkanı\n3. Savaş\n0. Çıkış");
            int locSelection = scan.nextInt();

            if (!selectLoc(locSelection)) {
                System.out.println(player.getName() + " OYUNU KAYBETTİN !!!");
                System.out.println("GAME OVER !!!! ");
                break;
            }else{
                if(player.inventory.isWater() && player.inventory.isFood() && player.inventory.isFireWood()
                        && isSafeHouse){
                    System.out.println(player.getName() + ", TÜM ÖDÜLLERİ TOPLADIN \nOYUNU KAZANDIN !!!");
                    break;
                }
            }
            if(locSelection==0){
                System.out.println("YİNE BEKLERİZ İYİ GÜNLER ..");
                break;
            }
            System.out.println("----------------------------------------------------------------------");

        }
    }

    public boolean selectLoc(int locSelection) {
        boolean isAlive = true;
        switch (locSelection) {
            case 1:
                location = new SafeHouse(this.player, "Guvenli Ev");
                isAlive=location.onLocatin();
                isSafeHouse=true;
                break;
            case 2:
                location = new ToolStore(this.player, "Araç Dükkanı");
                System.out.println("Şu anda Araç Dükkanındasınız");
               isAlive=location.onLocatin();
                break;
            case 3:
                System.out.println("Lütfen Savaş Alanı Seçiniz \n1. Magara,\n2. Orman,\n3. Nehir, \n4. Maden \n0. Çıkış");
                int battleLoc = scan.nextInt();
                if(isAwardGained(battleLoc)){
                    switch (battleLoc) {
                        case 1:
                            System.out.println("Mağaraya Hoş Geldin:");
                            BattleLoc cave   = new Cave(this.player, "Mağara", new Zombie(1));
                            cave.createMonsters(cave.getMonster());
                            isAlive = cave.onLocatin();
                            break;
                        case 2:
                            System.out.println("Ormana Hoş Geldin:");
                            BattleLoc forest   = new Forest(this.player, "Orman", new Vampire(2));
                            forest.createMonsters(forest.getMonster());
                            isAlive = forest.onLocatin();
                            break;
                        case 3:
                            System.out.println("Nehire Hoş Geldin:");
                            BattleLoc river   = new River(this.player, "Nehir", new Bear(3));
                            river.createMonsters(river.getMonster());
                            isAlive = river.onLocatin();
                            break;
                        case 4:
                            System.out.println("Madene Hoşgeldiniz:");
                            BattleLoc mine = new Mine(this.player, "Maden", new Snake(4));
                            mine.createMonsters(mine.getMonster());
                            isAlive = mine.onLocatin();
                            break;
                        case 0:
                            break;
                    }
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Geçerli Bir Lokasyon ID'si Girin:");
                break;

        }
        return isAlive;
    }

    public boolean isAwardGained(int battleLoc){
        if(battleLoc==1 && player.inventory.isFood()){
            System.out.println("Mağara Etabını Bitirdiniz Tekrar Giremezsiniz!!!");
            return false;
        }else if(battleLoc==2 && player.inventory.isFireWood()){
            System.out.println("Orman Etabını Bitirdiniz Tekrar Giremezsiniz!!!");
            return false;
        }else if(battleLoc==3 && player.inventory.isWater()){
            System.out.println("Nehir Etabını Bitirdiniz Tekrar Giremezsiniz!!!");
            return false;
        }
        return true;
    }

    public void charSelection(String playerName) {
        System.out.println("-----------------------------------------------------------------------");

        Player[] characters = {
                new Player(playerName, 1),
                new Player(playerName, 2),
                new Player(playerName, 3)
        };
        System.out.println("Karakterler");
        System.out.println("----------------------------------------------------------------------");

        for (Player each : characters) {
            System.out.println("Character : " + each.getCharName() + "\tHealth: " + each.getHealth() + ",\tDamage: " + each.getDamage());
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Lütfen Karakter Seçiniz: \n1. Samuray\n2. Okcu\n3. Sovalye");
        int charSelection = scan.nextInt();
        if(charSelection > 3 && charSelection < 0 || charSelection==0){
            charSelection=1;
        }
        player = new Player(playerName, charSelection);
        System.out.println("----------------------------------------------------------------------");
        player.characterInfo();
    }



}











