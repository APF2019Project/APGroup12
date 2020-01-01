package View;

import java.util.* ;
import Models.* ;
import Controller.* ;


public class View {
    public static String statusMenu = "Login menu" ;
    public static String gameType ;
    public Scanner scanner = new Scanner(System.in) ; ///
    



    public void loginMenu(){
        statusMenu = "Login menu";
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase("create account")){
            System.out.println("Please enter your username :");
            String username = scanner.nextLine();
            System.out.println("Please enter your password :");
            String password = scanner.nextLine() ;
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
            gameType = "Day" ;
            collectionMenu("plant" , Profile.currentProfile );
        }
        else if( inputString.equalsIgnoreCase( "Water")){
            statusMenu = "Collection menu";
            gameType = "Water" ;
            collectionMenu("plant" , Profile.currentProfile);
        }
        else if( inputString.equalsIgnoreCase( "Rail")){
            gameType = "Rail" ;

        }
        else if( inputString.equalsIgnoreCase( "Zombie")){
            statusMenu = "Collection menu";
            gameType = "Zombie" ;
            collectionMenu("zombie" , Profile.currentProfile);
        }
        else if( inputString.equalsIgnoreCase( "PvP")){
            String opponentUsername = scanner.nextLine() ;
            Profile opponent = Profile.getProfileObj( opponentUsername ) ;
            int numberOfWaves = scanner.nextInt() ;
            statusMenu = "Collection menu" ;
            gameType = "PvP" ;
            collectionMenu( "plant" , Profile.currentProfile);
            collectionMenu( "zombie" , opponent );
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

    public void collectionMenu(String type , Profile profile){
        String inputString = scanner.nextLine() ;
        if( inputString.equalsIgnoreCase( "Show hand")){
            if( type.equals("plant"))
                Controller.printArrayList( profile.getCollection().getPlantsCollection());
            else
                Controller.printArrayList( profile.getCollection().getZombieCollection());
        }
        else if( inputString.equalsIgnoreCase( "Show collection")){
            if( type.equals("plant") )
                profile.printUnSelectedCards("plant");
            else
                profile.printUnSelectedCards("zombie");
            collectionMenu( type , profile);
        }
        else if( inputString.matches("Select \\w")) {
            String[] splitInput = inputString.split(" ");
            String cardName =splitInput[1] ;
            Profile.currentProfile.selectCard( type , cardName );
            collectionMenu( type , profile);
        }
        else if( inputString.matches( "Remove \\w")){
            String[] splitString = inputString.split( " ");
            String cardName = splitString[1] ;
            Profile.currentProfile.removeCard( type , cardName );
            collectionMenu( type , profile );
        }
        else if( inputString.equalsIgnoreCase("Play"))
            Game.playGame();
        else if( inputString.equalsIgnoreCase("Help")) {
            printOptions();
            collectionMenu( type , profile );
        }
        else if( inputString.equalsIgnoreCase("Exit")) {
            statusMenu = "Play menu";
            playMenu();
        }
        else {
            System.out.println("Invalid command!");
            collectionMenu(type, profile);
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
        else if( inputString.matches("Buy \\w")){
            String[] splitString = inputString.split(" ");
            String cardName = splitString[1] ;
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



}
