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
        File plantsFolder = new File("C:\\Users\\Asus\\Desktop\\APGroup12\\src\\cards\\Plants") ;
        File zombiesFolder = new File("C:\\Users\\Asus\\Desktop\\APGroup12\\src\\cards\\Zombies") ;
        File accountFolder = new File("C:\\Users\\Asus\\Desktop\\APGroup12\\src\\cards\\Accounts") ;
        File[] plants = plantsFolder.listFiles();
        File[] zombies = zombiesFolder.listFiles();
        File[] accounts = accountFolder.listFiles();

        for ( int i = 0 ; i <plants.length ; i++){
            try {
                Plant plant = yaGson.fromJson( new FileReader( plants[i]) , Plant.class ) ;
                Plant.getAllPlants().add( plant ) ;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for ( int i = 0 ; i <zombies.length ; i++){
            try {
                Zombie zombie = yaGson.fromJson( new FileReader( zombies[i]) , Zombie.class ) ;
                Zombie.getAllZombies().add( zombie );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

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
                fw = new FileWriter(
                        "C:\\Users\\Asus\\Desktop\\APGroup12\\src\\cards\\Zombies\\" + ((Zombie) object).getName()+".json");
            else if(object instanceof Plant)
                fw = new FileWriter(
                        "C:\\Users\\Asus\\Desktop\\APGroup12\\src\\cards\\Plants\\" + ((Plant) object).getName() +".json");
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

    public static void createObjects(){

        //------------------------------- Zombies --------------------------------------//

        Zombie zombie = new Zombie( "zombie" , "Zombie" , 2 , 2 ) ;
        ZombiePower zombiePower13 = new ZombiePower() ;
        zombie.getPowers().add( zombiePower13 );
        writeJSONs(zombie);

        Zombie footballZombie  = new Zombie( "zombie" , "Football Zombie" , 4 , 3 ) ;
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setFootballer( true );
        footballZombie.getPowers().add( zombiePower ) ;
        writeJSONs( footballZombie );

        Zombie bucketHeadZombie = new Zombie( "zombie" , "Buckethead Zombie" , 3 , 2 ) ;
        ZombiePower zombiePower1 = new ZombiePower();
        zombiePower1.setBucketHead( true );
        bucketHeadZombie.getPowers().add( zombiePower1 ) ;
        writeJSONs( bucketHeadZombie );

        Zombie coneHeadZombie = new Zombie( "zombie" , "Conehead Zombie" , 3 , 2 ) ;
        writeJSONs( coneHeadZombie );

        Zombie zomboni = new Zombie( "zombie" , "Zomboni" , 3 , 2 ) ;
        ZombiePower zombiePower2 = new ZombiePower();
        zombiePower2.setStrongCar( true );
        zomboni.getPowers().add( zombiePower2 ) ;
        writeJSONs( zomboni );

        Zombie catapultZombie = new Zombie( "zombie" , "Catapult Zombie" , 3 , 2 ) ;
        ZombiePower zombiePower3 = new ZombiePower();
        zombiePower3.setWeakCar( true );
        catapultZombie.getPowers().add( zombiePower3 ) ;
        writeJSONs( catapultZombie );

        Zombie bungeeZombie = new Zombie( "zombie" , "Bungee Zombie" , 3 , 0 ) ;
        ZombiePower zombiePower4 = new ZombiePower();
        zombiePower4.setBungee( true );
        bungeeZombie.getPowers().add( zombiePower4 ) ;
        writeJSONs( bungeeZombie );

        Zombie balloonZombie = new Zombie( "zombie" , "Balloon Zombie" , 3 , 2 ) ;
        ZombiePower zombiePower5 = new ZombiePower();
        zombiePower5.setBalloon( true );
        balloonZombie.getPowers().add( zombiePower5 ) ;
        writeJSONs( balloonZombie );

        Zombie newspaperZombie = new Zombie( "zombie" , "Newspaper Zombie" , 2 , 2 ) ;
        ZombiePower zombiePower6 = new ZombiePower();
        zombiePower6.setNewspaper( true );
        newspaperZombie.getPowers().add( zombiePower6 ) ;
        writeJSONs( newspaperZombie );

        Zombie targetZombie = new Zombie( "zombie" , "Target Zombie" , 3 , 2 ) ;
        ZombiePower zombiePower7 = new ZombiePower();
        zombiePower7.setTarget( true );
        targetZombie.getPowers().add( zombiePower7 ) ;
        writeJSONs( targetZombie );

        Zombie ScreenDoorZombie = new Zombie( "zombie" , "Screen Door Zombie" , 2 , 2 ) ;
        ZombiePower zombiePower8 = new ZombiePower();
        zombiePower8.setScreenDoor( true );
        ScreenDoorZombie.getPowers().add( zombiePower8 ) ;
        writeJSONs( ScreenDoorZombie );

        Zombie gigaGargantuar = new Zombie( "zombie" , "Giga-gargantuar" , 6 , 1 ) ;
        ZombiePower zombiePower9 = new ZombiePower();
        zombiePower9.setGigaGargantuar( true );
        gigaGargantuar.getPowers().add( zombiePower9 ) ;
        writeJSONs( gigaGargantuar );

        Zombie pogoZombie = new Zombie( "zombie" , "Pogo Zombie" , 2 , 2 ) ;
        ZombiePower zombiePower10 = new ZombiePower();
        zombiePower10.setPogo( true );
        pogoZombie.getPowers().add( zombiePower10 ) ;
        writeJSONs( pogoZombie );

        Zombie snorkelZombie = new Zombie( "zombie" , "Snorkel Zombie" , 2 , 2 ) ;
        ZombiePower zombiePower11 = new ZombiePower();
        zombiePower11.setSnorkel( true );
        snorkelZombie.getPowers().add( zombiePower11 ) ;
        writeJSONs( snorkelZombie );

        Zombie dolphinZombie = new Zombie( "zombie" , "Dolphin Rider Zombie" , 2 , 2 ) ;
        ZombiePower zombiePower12 = new ZombiePower();
        zombiePower12.setDolphinRider( true );
        dolphinZombie.getPowers().add( zombiePower12 ) ;
        writeJSONs( dolphinZombie );


        // ----------------------------------- plants ------------------------------------//

        Plant peaShooter = new Plant( "plant" ,"Peashooter" , 2 , 2 , 2 );
        PlantPower plantPower = new PlantPower() ;
        plantPower.setPeaShooter( true );
        peaShooter.getPowers().add( plantPower ) ;
        writeJSONs( peaShooter );

        Plant snowPea = new Plant( "plant" ,"Snow Pea" , 3 , 3 , 3 );
        PlantPower plantPower1 = new PlantPower() ;
        plantPower1.setSnowPea( true );
        snowPea.getPowers().add( plantPower1 );
        writeJSONs( snowPea );

        Plant cabbagePult = new Plant( "plant" ,"Cabbage-pult" , 2 , 3 , 2 );
        PlantPower plantPower2 = new PlantPower() ;
        plantPower1.setCabbagePult( true );
        cabbagePult.getPowers().add( plantPower2 );
        writeJSONs( cabbagePult );

        Plant repeater = new Plant( "plant" ,"Repeater" , 4 , 4 , 3 );
        PlantPower plantPower3 = new PlantPower() ;
        plantPower3.setRepeater( true );
        repeater.getPowers().add( plantPower3 );
        writeJSONs( repeater );

        Plant threepeater = new Plant( "plant" ,"Threepeater" , 5 , 4 , 4 );
        PlantPower plantPower4 = new PlantPower() ;
        plantPower4.setThreepeater( true );
        threepeater.getPowers().add( plantPower4 );
        writeJSONs( threepeater );

        Plant cactus = new Plant( "plant" ,"Cactus" , 5 , 4 , 5 );
        PlantPower plantPower5 = new PlantPower() ;
        plantPower5.setCactus( true );
        cactus.getPowers().add( plantPower5 );
        writeJSONs( cactus );

        Plant gatlingPea = new Plant( "plant" ,"Gatling Pea" , 3 , 4 , 5 );
        PlantPower plantPower6 = new PlantPower() ;
        plantPower6.setGatlingPea( true );
        gatlingPea.getPowers().add( plantPower6 );
        writeJSONs( gatlingPea );

        Plant scaredyShroom  = new Plant( "plant" ,"Scaredy-shroom" , 1 , 2 , 1 );
        PlantPower plantPower7 = new PlantPower() ;
        plantPower7.setScaredyShroom( true );
        scaredyShroom.getPowers().add( plantPower7 );
        writeJSONs( scaredyShroom );

        Plant kernelPult = new Plant( "plant" ,"Kernel-pult" , 2 , 3 , 3 );
        PlantPower plantPower8 = new PlantPower() ;
        plantPower8.setKernelPult( true );
        kernelPult.getPowers().add( plantPower8 );
        writeJSONs( kernelPult );

        Plant splitPea = new Plant( "plant" ,"Split Pea" , 3 , 4 , 4 );
        PlantPower plantPower9 = new PlantPower() ;
        plantPower9.setSplitPea( true );
        splitPea.getPowers().add( plantPower9 );
        writeJSONs( splitPea );

        Plant explodeNut = new Plant( "plant" ,"Explode-o-nut" , 3 , 5 , 4 );
        PlantPower plantPower10 = new PlantPower() ;
        plantPower10.setExplodeNut( true );
        explodeNut.getPowers().add( plantPower10 );
        writeJSONs( explodeNut );

        Plant melonPult = new Plant( "plant" ,"Melon-pult" , 3 , 3 , 3 );
        PlantPower plantPower11 = new PlantPower() ;
        plantPower11.setMelonPult( true );
        melonPult.getPowers().add( plantPower11 );
        writeJSONs( melonPult );

        Plant lilyPad = new Plant( "plant" ,"Lily Pad" , 1 , 1 , 0 );
        PlantPower plantPower12 = new PlantPower() ;
        plantPower12.setLilyPad( true );
        lilyPad.getPowers().add( plantPower12 );
        writeJSONs( lilyPad );

        Plant winterMelon = new Plant( "plant" ,"Winter Melon" , 3 , 5 , 4 );
        PlantPower plantPower13 = new PlantPower() ;
        plantPower13.setWinterMelon( true );
        winterMelon.getPowers().add( plantPower13 );
        writeJSONs( winterMelon );

        Plant wallNut = new Plant( "plant" ,"Wall-nut" , 4 , 4 , 2 );
        PlantPower plantPower14 = new PlantPower() ;
        plantPower14.setWallNut( true );
        wallNut.getPowers().add( plantPower14 );
        writeJSONs( wallNut );

        Plant tangleKelp = new Plant( "plant" ,"Tangle Kelp" , 0 , 3 , 3 );
        PlantPower plantPower15 = new PlantPower() ;
        plantPower15.setTangleKelp( true );
        tangleKelp.getPowers().add( plantPower15);
        writeJSONs( tangleKelp );

        Plant tallNut = new Plant( "plant" ,"Tall-nut" , 6 , 6 , 4 );
        PlantPower plantPower16 = new PlantPower() ;
        plantPower16.setTallNut( true );
        tallNut.getPowers().add( plantPower16 );
        writeJSONs( tallNut );

        Plant cattail = new Plant( "plant" ,"Cattail" , 3 , 5 , 5 );
        PlantPower plantPower17 = new PlantPower() ;
        plantPower17.setCattail( true );
        cattail.getPowers().add( plantPower17 );
        writeJSONs( cattail );

        Plant cherryBomp = new Plant( "plant" ,"Cherry Bomb" , 900 , 4 , 2 );
        PlantPower plantPower18 = new PlantPower() ;
        plantPower18.setCherryBomb( true );
        cherryBomp.getPowers().add( plantPower18 );
        writeJSONs( cherryBomp  );

        Plant magnetShroom = new Plant( "plant" ,"Magnet-shroom" , 2 , 4 , 4 );
        PlantPower plantPower19 = new PlantPower() ;
        plantPower19.setMagnetShroom( true );
        magnetShroom.getPowers().add( plantPower19 );
        writeJSONs( magnetShroom );

        Plant sunFlower = new Plant( "plant" ,"Sunflower" , 2 , 2 , 1 );
        PlantPower plantPower20 = new PlantPower() ;
        plantPower20.setSunFlower( true );
        sunFlower.getPowers().add( plantPower20 );
        writeJSONs( sunFlower );

        Plant twinSunFlower = new Plant( "plant" ,"Twin Sunflower" , 2 , 5 , 3 );
        PlantPower plantPower21 = new PlantPower() ;
        plantPower21.setTwinSunflower( true );
        twinSunFlower.getPowers().add( plantPower21 );
        writeJSONs( twinSunFlower );

        Plant jalapeno = new Plant( "plant" ,"Jalapeno" , 900 , 5 , 4 );
        PlantPower plantPower22 = new PlantPower() ;
        plantPower22.setJalapeno( true );
        jalapeno.getPowers().add( plantPower22 );
        writeJSONs( jalapeno );     // health ?????

    }
}
