package View;

import Controller.Controller;
import Models.*;
import Models.Map;

import java.util.*;
import java.util.regex.Pattern;


public class View {
    public static String statusMenu = "Login menu" ;
    public static String gameType ;
    private static final String name = "([\\S\\s]+)";
    private static final String number = "([0-9]+)";
    public Scanner scanner = new Scanner(System.in) ; ///

    public void invalidCommand()
    {
        System.out.println("Invalid command");
    }
    private void plantsTurn()
    {
        System.out.println("Plants turn");
    }
    private void zombiesTurn()
    {
        System.out.println("Zombies turn");
    }

    public void loginMenu(){
        statusMenu = "Login menu";
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase("create account")){
            System.out.println("Please enter your username :");
            String username = scanner.nextLine();
            System.out.println("Please enter your password :");
            String password = scanner.nextLine() ;
            while ( true ){
                if( ! Controller.usernameExists( username ))
                    break;
                username = scanner.nextLine() ;
            }
            Profile.currentProfile = Controller.getNewProfile( username , password ) ;
            loginMenu();
        }
        else if( inputString.equalsIgnoreCase( "Login")){
            while (true){
                System.out.println("Please enter your username :");
                String username = scanner.nextLine() ;
                System.out.println("Please enter your password :");
                String password = scanner.nextLine() ;
                Profile.currentProfile = Profile.getProfileObj( username , password ) ;
                if( Profile.currentProfile != null )
                    break;
                System.out.println("Not found ! please try again ");
            }
            statusMenu = "Main menu" ;
            mainMenu();
        }
        else if( inputString.equalsIgnoreCase("LeaderBoard") ) {
            statusMenu = "LeaderBoard" ;
            showLeaderBoard();
        }
        else if( inputString.equalsIgnoreCase("Help")) {
            printOptions();
            loginMenu();
        }
        else if( inputString.equalsIgnoreCase("Exit"))
            System.exit(0);
        else {
            System.out.println("Invalid command !");
            loginMenu();
        }
    }

    public void mainMenu(){
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase("Play")){
            statusMenu = "Play menu" ;
            playMenu();
        }
        else if( inputString.equalsIgnoreCase("Profile")){
            statusMenu = "Profile menu" ;
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase("Shop")){
            statusMenu = "Shop menu" ;
            shopMenu();
        }
        else if( inputString.equalsIgnoreCase( "Help")) {
            printOptions();
            mainMenu();
        }
        else if( inputString.equalsIgnoreCase("Exit")) {
            statusMenu = "Login menu";
            loginMenu();
        }
        else {
            System.out.println("Invalid command!");
            mainMenu();
        }
    }

    public void profileMenu(){
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase( "Change")){
            String username = scanner.nextLine() ;
            String password = scanner.nextLine() ;
            Profile.currentProfile = Profile.currentProfile.getProfileObj(username,password) ;
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase( "Delete")){
            Profile profile ;
            while ( true ) {
                System.out.println("Please enter your username:");
                String username = scanner.nextLine() ;
                System.out.println("Please enter your password:");
                String password = scanner.nextLine() ;
                profile = Profile.getProfileObj(username,password) ;
                if (profile != null)
                    break;
                System.out.println("Not found! please try again:");
            }
            Profile.getAllProfiles().remove( profile ) ;
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase( "Rename")){
            System.out.println("Please enter your new username:");
            String username = scanner.nextLine() ;
            Profile.currentProfile.setUsername( username );
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase("Create")){
            System.out.println("Please enter your username:");
            String username = scanner.nextLine() ;
            while (true) {
                if (! Controller.usernameExists(username))
                    break;
                System.out.println("This username is already exist! please enter another one:");
                username = scanner.nextLine();
            }
            System.out.println("Please enter your password:");
            String password = scanner.nextLine() ;
            Profile.currentProfile = Controller.getNewProfile( username , password ) ;
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase( "Show")) {
            System.out.println(Profile.currentProfile.getUsername());
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase("Help")) {
            printOptions();
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase( "Exit")) {
            statusMenu = "Main menu";
            mainMenu();
        }
        else {
            System.out.println("Invalid command !");
            profileMenu();
        }
    }

    public void playMenu(){
        String inputString =scanner.nextLine() ;
        if( inputString.equalsIgnoreCase("Day")){
            statusMenu = "Collection menu";
            gameType = "plant" ;
            collectionMenu( gameType , Profile.currentProfile );
            run(DayMode.createDayMode(Map.createMap("Land" , true) , Profile.currentProfile.getCollection() ,
                    Zombie.getAllZombies() , false) , Profile.currentProfile , false);
        }
        else if( inputString.equalsIgnoreCase( "Water")){
            statusMenu = "Collection menu";
            gameType = "plant" ;
            collectionMenu( gameType , Profile.currentProfile );
            run(DayMode.createDayMode(Map.createMap("Water" , true) , Profile.currentProfile.getCollection() ,
                    Zombie.getAllZombies() , false) , Profile.currentProfile , false);
        }
        else if( inputString.equalsIgnoreCase( "Rail")){
            statusMenu = "Collection menu";
            gameType = "Rail" ;
            collectionMenu( "plant" , Profile.currentProfile );
            run(RailMode.createRailMode(Map.createMap("Land" , true) , Profile.currentProfile.getCollection() ,
                    Zombie.getAllZombies()) , Profile.currentProfile , false);
        }
        else if( inputString.equalsIgnoreCase( "Zombie")){
            statusMenu = "Collection menu";
            gameType = "zombie" ;
            collectionMenu( gameType , Profile.currentProfile );
            run(ZombieMode.createZombieMode(Map.createMap("Land" , true) , Plant.getAllPlants() ,
                    Profile.currentProfile.getCollection() , false) , Profile.currentProfile , false);
        }
        else if( inputString.equalsIgnoreCase( "PvP")){
            System.out.println("Player 2 , Please enter your username:");
            String username = scanner.nextLine() ;
            System.out.println("Player 2 , Please enter your password:");
            String password = scanner.nextLine() ;
            Profile opponent ;
            while ( true ) {
                opponent = Profile.getProfileObj( username , password ) ;
                if ( opponent != null)
                    break;
                System.out.println("Player 2 , Please enter your username:");
                username = scanner.nextLine() ;
                System.out.println("Player 2 , Please enter your password:");
                password = scanner.nextLine() ;
            }
            System.out.println("Please enter number of waves:");
            int numberOfWaves = scanner.nextInt() ;
            statusMenu = "Collection menu" ;
            gameType = "PvP" ;
            collectionMenu( "plant" ,  Profile.currentProfile );
            collectionMenu( "zombie" , opponent );
            run(MultiPlayerMode.createMultiPlayerMode(Map.createMap("Land" , true) ,
                    Profile.currentProfile.getCollection() , opponent.getCollection() , numberOfWaves) ,
                    Profile.currentProfile , opponent);
        }
        else if( inputString.equalsIgnoreCase( "Help")) {
            printOptions();
            playMenu();
        }
        else if( inputString.equalsIgnoreCase( "Exit")) {
            statusMenu = "Main menu";
            mainMenu();
        }
        else {
            System.out.println("Invalid command!");
            playMenu();
        }
    }

    public void collectionMenu( String gameType , Profile profile ){
        System.out.println( profile.getUsername() + "'s" + " " + "collection:");
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase( "Show hand")){
            Controller.printArrayList( profile.getCollection().getList() );
            collectionMenu( gameType , profile );
        }
        else if( inputString.equalsIgnoreCase( "Show collection")){
            if( gameType.equals("plant") )
                profile.printUnSelectedCards("plant");
            else
                profile.printUnSelectedCards("zombie");
            collectionMenu( gameType , profile );
        }
        else if( inputString.matches("select " + name)) {
            String cardName = inputString.substring(7);
            Profile.currentProfile.selectCard( gameType , cardName );
            collectionMenu( gameType , profile);
        }
        else if( inputString.matches( "remove " + name)){
            String cardName = inputString.substring(7);
            Profile.currentProfile.removeCard( cardName );
            collectionMenu( gameType , profile );
        }
        else if( inputString.equalsIgnoreCase("Play"))
        {
            statusMenu = "Play menu";
        }
        else if( inputString.equalsIgnoreCase("Help")) {
            printOptions();
            collectionMenu( gameType , profile );
        }
        else if( inputString.equalsIgnoreCase("Exit")) {
            statusMenu = "Play menu";
            playMenu();
        }
        else {
            System.out.println("Invalid command!");
            collectionMenu(gameType, profile);
        }
    }

    public void shopMenu(){
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase("Show shop") ) {
            Profile.currentProfile.printShopCards();
            shopMenu();
        }
        else if( inputString.equalsIgnoreCase("Show collection ")){
            Controller.printArrayList( Profile.currentProfile.getBoughtCards() );
            shopMenu();
        }
        else if( inputString.matches("buy " + name)){
            String cardName = inputString.substring(7);
            Profile.currentProfile.buyCard( cardName );
            shopMenu();
        }
        else if( inputString.equalsIgnoreCase("Money")) {
            System.out.println(Profile.currentProfile.getUsername() + "'s coins: " + Profile.currentProfile.getCoins());
            shopMenu();
        }
        else if( inputString.equalsIgnoreCase("Help")) {
            printOptions();
            shopMenu();
        }
        else if( inputString.equalsIgnoreCase("Exit")) {
            statusMenu = "Main menu";
            mainMenu();
        }
        else {
            System.out.println("Invalid command!");
            shopMenu();
        }

    }

    public void showLeaderBoard(){
        Collections.sort( Profile.getAllProfiles() , new ProfileComparator());
        System.out.println("LeaderBoard:");
        for ( Profile profile : Profile.getAllProfiles()) {
            System.out.printf( "%d- %s --> record: %d\n" ,
                    (Profile.getAllProfiles().indexOf(profile)+1) , profile.getUsername() , profile.getRecord());
        }
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase("Exit")){
            statusMenu = "Login menu" ;
            loginMenu();
        }
        else if( inputString.equalsIgnoreCase("Help")) {
            System.out.println("Exit");
            showLeaderBoard();
        }
        else{
            System.out.println("Invalid command!");
            showLeaderBoard();
        }

    }

    public void printOptions(){
        String[] loginMenuOptions = { "Create account" , "Login" , "LeaderBoard" } ;
        String[] mainMenuOptions = { "Play" , "Profile" , "Shop" } ;
        String[] profileMenuOptions = { "Change" , "Delete" , "Rename" , "Create" , "Show" } ;
        String[] playMenuOptions = { "Day" , "Water" , "Rail" , "Zombie" , "PvP"} ;
        String[] collectionMenuOptions = { "Show hand" , "Show collection" , "Select" , "Remove" , "Play" } ;
        String[] shopMenuOption = { "Show shop" , "Show collection" , "Buy" , "Money" } ;

        List <String> options ;
        switch ( statusMenu ){
            case "Login menu" :
                options = Arrays.asList( loginMenuOptions ) ;
                break;
            case "Main menu" :
                options = Arrays.asList( mainMenuOptions ) ;
                break;
            case "Profile menu" :
                options = Arrays.asList( profileMenuOptions ) ;
                break;
            case "Play menu" :
                options = Arrays.asList( playMenuOptions ) ;
                break;
            case "Collection menu" :
                options = Arrays.asList( collectionMenuOptions ) ;
                break;
            case "Shop menu" :
                options = Arrays.asList( shopMenuOption ) ;
                break;
            default:
                options = new ArrayList<>() ;
        }
        for ( String option : options)
            System.out.println(option);

    }

    public void run(Day game , Profile profile , boolean pvp)
    {
        while (true)
        {
            String input = scanner.nextLine();

            if (game.isEnded())
            {
                break;
            }

            if (input.equals("end"))
            {
                return;
            }
            else if (pvp && input.equals("ready"))
            {
                return;
            }
            else if (input.equals("show"))
            {
                game.showLawn();
            }
            else if (game instanceof DayMode && input.equals("sun"))
            {
                System.out.println(((DayMode) game).getSuns());
            }
            else if (game instanceof RailMode && input.equals("record"))
            {
                System.out.println(game.getMap().getDeadZombies());
            }
            else if (Pattern.matches("select " + number , input))
            {
                game.select(Integer.parseInt(input.substring(7)));
            }
            else if (Pattern.matches("select " + name , input))
            {
                game.select(input.substring(7));
            }
            else if (Pattern.matches("plant " + number + " " + number , input))
            {
                String[] command = input.split(" ");
                game.plant(Integer.parseInt(input.split(" ")[1]) , Integer.parseInt(input.split(" ")[2]));
            }
            else if (!pvp && input.equals("end turn"))
            {
                game.endTurn();
                game.getMap().show();
                game.showHand();
                System.out.println();
            }
        }

        if (!pvp)
        {
            profile.setRecord(Math.max(profile.getRecord() , game.getMap().getDeadZombies()));
            profile.setCoins(profile.getCoins() + game.getMap().getDeadZombies());
        }
    }

    public void run(ZombieMode game , Profile profile , boolean pvp)
    {
        while (true)
        {
            String input = scanner.nextLine();

            if (game.isEnded())
            {
                break;
            }

            if (input.equals("end"))
            {
                return;
            }
            else if (pvp && input.equals("ready"))
            {
                return;
            }
            else if (input.equals("show"))
            {
                game.showLawn();
            }
            else if (input.equals("coin"))
            {
                System.out.println(game.getCoins());
            }
            else if (input.equals("show lanes"))
            {
                game.showLanes();
            }
            else if (input.equals("start"))
            {
                game.start();
            }
            else if (Pattern.matches("put " + name + " " + number + " " + number , input))
            {
                String[] command = input.split(" ");
                StringBuilder zName = new StringBuilder(command[1]);

                for (int i = 2; i < command.length - 2; i++)
                {
                    zName.append(" ").append(command[i]);
                }

                game.put(zName.toString() , Integer.parseInt(command[command.length - 2]) , Integer.parseInt(command[command.length - 1]));
            }
            else if (!pvp && input.equals("end turn"))
            {
                game.endTurn();
                game.getMap().show();
                game.showHand();
                System.out.println();
            }
            else
            {
                invalidCommand();
            }
        }

        if (!pvp) profile.setCoins(profile.getCoins() + game.getMap().getDeadPlants());
    }

    public void run(MultiPlayerMode game , Profile first , Profile second)
    {
        while (true)
        {
            if (game.isEnded())
            {
                break;
            }

            plantsTurn();
            run(game.getPlants() , first , true);
            game.ready();

            if (game.isEnded())
            {
                break;
            }

            zombiesTurn();
            run(game.getZombies() , second , true);
            game.ready();
        }
    }
}