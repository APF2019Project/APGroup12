package Models;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class JSONHandler {

    public static void readAllFromJsons(){
        YaGson yaGson = new YaGson() ;
        File zombieFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Zombies\\Zombie\\") ;
        File scardyshroomFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Scardyshroom\\") ;
        File threepeaterFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Threepeater\\") ;
        File splitPeaFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\SplitPea\\") ;
        File attackerPlantFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\AttackerPlant\\") ;
        File explosivePlantFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\ExplosivePlant\\") ;
        File sunflowerFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Sunflower\\") ;
        File magnetshroomFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Magnetshroom\\") ;
        File plantsFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Plant\\") ;
        //File accountFolder = new File("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Accounts") ;
        File[] zombie = zombieFolder.listFiles();
        File[] scardyshroom = scardyshroomFolder.listFiles();
        File[] threepeater = threepeaterFolder.listFiles();
        File[] splitPea = splitPeaFolder.listFiles();
        File[] attackerPlant = attackerPlantFolder.listFiles();
        File[] explosivePlant = explosivePlantFolder.listFiles();
        File[] sunflower = sunflowerFolder.listFiles();
        File[] magnetshroom = magnetshroomFolder.listFiles();
        File[] plant = plantsFolder.listFiles();
        //File[] accounts = accountFolder.listFiles();

        for (File file : zombie) {
            try {
                Zombie zombieX = yaGson.fromJson(new FileReader(file), Zombie.class);
                Zombie.getAllZombies().add(zombieX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : scardyshroom) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), Scardyshroom.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : threepeater) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), Threepeater.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : splitPea) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), SplitPea.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : attackerPlant) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), AttackerPlant.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : explosivePlant) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), ExplosivePlant.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : magnetshroom) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), Magnetshroom.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : sunflower) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), Sunflower.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : plant) {
            try {
                Plant plantX = yaGson.fromJson(new FileReader(file), Plant.class);
                Plant.getAllPlants().add(plantX);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Plant.addAll();
        Zombie.addAll();

//        for ( int i = 0 ; i < accounts.length ; i++){
//            try {
//                Profile profile = yaGson.fromJson( new FileReader( accounts[i]) , Profile.class ) ;
//                Profile.getAllProfiles().add( profile);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

    }
    public static void writeJSONs( Object object ){
        try {
            YaGson yaGson = new YaGsonBuilder().setPrettyPrinting().create();
            String str = yaGson.toJson(object);
            FileWriter fw = null ;
            if(object instanceof Zombie)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Zombies\\Zombie\\" +
                        ((Zombie) object).getName()+".json");
            else if(object instanceof Scardyshroom)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Scardyshroom\\" +
                        ((Scardyshroom) object).getName() +".json");
            else if(object instanceof Threepeater)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Threepeater\\" +
                        ((Threepeater) object).getName() +".json");
            else if(object instanceof SplitPea)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\SplitPea\\" +
                        ((SplitPea) object).getName() +".json");
            else if(object instanceof AttackerPlant)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\AttackerPlant\\" +
                        ((AttackerPlant) object).getName() +".json");
            else if(object instanceof ExplosivePlant)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\ExplosivePlant\\" +
                        ((ExplosivePlant) object).getName() +".json");
            else if(object instanceof Sunflower)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Sunflower\\" +
                        ((Sunflower) object).getName() +".json");
            else if(object instanceof Magnetshroom)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Magnetshroom\\" +
                        ((Magnetshroom) object).getName() +".json");
            else if(object instanceof Plant)
                fw = new FileWriter("C:\\Users\\asus\\Desktop\\APGroup12\\src\\cards\\Plants\\Plant\\" +
                        ((Plant) object).getName() +".json");
//            else if(object instanceof Profile)
//                fw = new FileWriter(
//                        "C:\\Users\\Asus\\Desktop\\APGroup12\\src\\cards\\Accounts\\" + ((Profile) object).getUsername() +".json");
            else
                return;
            fw.write(str);
            fw.close();
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    public static void createObjects() {

        //------------------------------- Zombies --------------------------------------//

        writeJSONs(Zombie.getZombie());
        writeJSONs(Zombie.getFootballZombie());
        writeJSONs(Zombie.getBucketheadZombie());
        writeJSONs(Zombie.getConeheadZombie());
        writeJSONs(Zombie.getZomboni());
        writeJSONs(Zombie.getCatapultZombie());
        writeJSONs(Zombie.getBungeeZombie());
        writeJSONs(Zombie.getBalloonZombie());
        writeJSONs(Zombie.getNewspaperZombie());
        writeJSONs(Zombie.getTargetZombie());
        writeJSONs(Zombie.getScreenDoorZombie());
        writeJSONs(Zombie.getGigagargantuar());
        writeJSONs(Zombie.getPogoZombie());
        writeJSONs(Zombie.getSnorkelZombie());
        writeJSONs(Zombie.getDolphinRiderZombie());

        // ----------------------------------- plants ------------------------------------//

        writeJSONs(Plant.getPeashooter());
        writeJSONs(Plant.getSnowPea());
        writeJSONs(Plant.getCabbagepult());
        writeJSONs(Plant.getRepeater());
        writeJSONs(Plant.getThreepeater());
        writeJSONs(Plant.getCactus());
        writeJSONs(Plant.getGatlingPea());
        writeJSONs(Plant.getScardyShroom());
        writeJSONs(Plant.getKernelpult());
        writeJSONs(Plant.getSplitPea());
        writeJSONs(Plant.getExplodeonut());
        writeJSONs(Plant.getMelonpult());
        writeJSONs(Plant.getLilyPad());
        writeJSONs(Plant.getWinterMelon());
        writeJSONs(Plant.getWallnut());
        writeJSONs(Plant.getTangleKelp());
        writeJSONs(Plant.getTallnut());
        writeJSONs(Plant.getCattail());
        writeJSONs(Plant.getPotatoMine());
        writeJSONs(Plant.getCherryBomb());
        writeJSONs(Plant.getMagnetshroom());
        writeJSONs(Plant.getSunflower());
        writeJSONs(Plant.getTwinSunflower());
        writeJSONs(Plant.getJalapeno());
    }
}