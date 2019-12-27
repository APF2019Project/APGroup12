package View;

import java.util.* ;
import Models.* ;
import Controller.* ;

public class View {
    public static String menuStatus = "Login menu" ;
    public static String gameType ;
    public Scanner scanner = new Scanner(System.in) ;
    
    


    

//    public void menuController (){
//        String status = menuStatus ;
//        switch ( status ) {
//            case "Login menu" :
//                loginMenu();
//                break;
//            case "Main menu" :
//                mainMenu();
//                break;
//            case "Profile menu" :
//                profileMenu();
//                break;
//            case "Play menu" :
//                playMenu();
//                break;
//            case "Collection menu" :
//                collectionMenu();
//                break;
//            case "Shop menu" :
//                shopMenu();
//                break;
//            case "LeaderBoard" :
//                showLeaderBoard() ;
//                break;
//        }
//    }


    public void loginMenu(){
        String inputString = scanner.next() ;
        if( inputString.equalsIgnoreCase("Create account")){
            System.out.println("Please enter your username :");
            String username = scanner.next();
            System.out.println("Please enter your password :");
            String password = scanner.next() ;
            Account.currentAccount = Controller.getNewAccount( username , password ) ;
            loginMenu();
        }
        else if( inputString.equalsIgnoreCase( "Login")){
            System.out.println("Please enter your username :");
            String username = scanner.next() ;
            System.out.println("Please enter your password :");
            String password = scanner.next() ;
            Account.currentAccount = Account.getAccountObj( username , password ) ;
            if( Account.currentAccount == null )
                System.out.println("Not found ! please try again ");
            menuStatus = "Main menu" ;
            mainMenu();
        }
        else if( inputString.equalsIgnoreCase("LeaderBoard") ) {
            menuStatus = "LeaderBoard" ;
            showLeaderBoard();
        }
        else if( inputString.equalsIgnoreCase("Help"))
            printOptions();
        else if( inputString.equalsIgnoreCase("Exit"))
            System.exit(0);
        else
            System.out.println("Invalid command !");
    }

    public void mainMenu(){
        String inputString = scanner.next() ;
        if( inputString.equalsIgnoreCase("Play")){
            menuStatus = "Play menu" ;
            playMenu();
        }
        else if( inputString.equalsIgnoreCase("Profile")){
            menuStatus = "Profile menu" ;
            profileMenu();
        }
        else if( inputString.equalsIgnoreCase("Shop")){
            menuStatus = "Shop menu" ;
            shopMenu();
        }
        else if( inputString.equalsIgnoreCase( "Help"))
            printOptions();
        else if( inputString.equalsIgnoreCase("Exit"))
            menuStatus = "Login menu" ;
        else
            System.out.println("Invalid command !");
    }

    public void profileMenu(){
        String inputString = scanner.next() ;
        if( inputString.equalsIgnoreCase( "Change")){
            String username = scanner.next() ;
            String password = scanner.next() ;
            Profile.currentProfile = Account.currentAccount.getProfileObj(username,password) ;
        }
        else if( inputString.equalsIgnoreCase( "Delete")){
            String username = scanner.next() ;
            String password = scanner.next() ;
            Account.currentAccount.getProfiles().remove( Account.currentAccount.getProfileObj(username,password)) ;
        }
        else if( inputString.equalsIgnoreCase( "Rename")){
            String username = scanner.next() ;
            Profile.currentProfile.setUsername( username );
        }
        else if( inputString.equalsIgnoreCase("Create")){
            String username = scanner.next() ;
            while (true) {
                if (! Controller.usernameExists(username))
                    break;
                username = scanner.next();
            }
            String password = scanner.next() ;
            Profile.currentProfile = Controller.getNewProfile( username , password , Account.currentAccount ) ;
        }
        else if( inputString.equalsIgnoreCase( "Show"))
            System.out.println( Profile.currentProfile.getUsername() );
        else if( inputString.equalsIgnoreCase("Help"))
            printOptions();
        else if( inputString.equalsIgnoreCase( "Exit"))
            menuStatus = "Main menu" ;
        else
            System.out.println("Invalid command !");
    }

    public void playMenu(){
        String inputString =scanner.next() ;
        if( inputString.equalsIgnoreCase("Day")){
            gameType = "Day" ;
            collectionMenu("plant" , Profile.currentProfile );
        }
        else if( inputString.equalsIgnoreCase( "Water")){
            gameType = "Water" ;
            collectionMenu("plant" , Profile.currentProfile);
        }
        else if( inputString.equalsIgnoreCase( "Rail")){

        }
        else if( inputString.equalsIgnoreCase( "Zombie")){
            gameType = "Zombie" ;
            collectionMenu("zombie" , Profile.currentProfile);
        }
        else if( inputString.equalsIgnoreCase( "PvP")){
            String opponentUsername = scanner.next() ;
            Profile opponent = Profile.getProfileObj( opponentUsername ) ;
            int numberOfWaves = scanner.nextInt() ;
            collectionMenu( "plant" , Profile.currentProfile);
            collectionMenu( "zombie" , opponent );
        }
        else if( inputString.equalsIgnoreCase( "Help"))
            printOptions();
        else if( inputString.equalsIgnoreCase( "Exit"))
            menuStatus = "Main menu" ;
        else
            System.out.println("Invalid command!");
    }

    public void collectionMenu(String type , Profile profile){
        String inputString = scanner.next() ;
        if( inputString.equalsIgnoreCase( "Show hand")){
            if( type.equals("plant"))
                Controller.printArrayList( profile.getPlantCollection());
            else
                Controller.printArrayList( profile.getZombieCollection());
        }
        else if( inputString.equalsIgnoreCase( "Show collection")){
            if( type.equals("plant") )
                profile.printUnSelectedCards("plant");
            else
                profile.printUnSelectedCards("zombie");
        }
        else if( inputString.matches("Select \\w")) {
            String[] splitInput = inputString.split(" ");
            String cardName =splitInput[1] ;
            Profile.currentProfile.selectCard( type , cardName );
        }
        else if( inputString.matches( "Remove \\w")){
            String[] splitString = inputString.split( " ");
            String cardName = splitString[1] ;
            Profile.currentProfile.removeCard( type , cardName );
        }
        else if( inputString.equalsIgnoreCase("Play"))
            Game.playGame();
        else if( inputString.equalsIgnoreCase("Help"))
            printOptions();
        else if( inputString.equalsIgnoreCase("Exit"))
            menuStatus = "Play menu" ;
        else
            System.out.println("Invalid command!");
    }

    public void shopMenu(){
        String inputString = scanner.next() ;
        if( inputString.equalsIgnoreCase("Show shop") )
            Profile.currentProfile.printShopCards();
        else if( inputString.equalsIgnoreCase("Show collection ")){
            Controller.printArrayList( Profile.currentProfile.getBoughtCards() );
        }
        else if( inputString.matches("Buy \\w")){
            String[] splitString = inputString.split(" ");
            String cardName = splitString[1] ;
            Profile.currentProfile.buyCard( cardName );
        }
        else if( inputString.equalsIgnoreCase("Money"))
            System.out.println( Profile.currentProfile.getUsername()+"'s coins: "+Profile.currentProfile.getCoins());
        else if( inputString.equalsIgnoreCase("Help"))
            printOptions();
        else if( inputString.equalsIgnoreCase("Exit"))
            menuStatus = "Main menu" ;
        else
            System.out.println("Invalid command!");

    }

    public void showLeaderBoard(){
        String inputString = scanner.next() ;
    }

    public void printOptions(){
        String[] loginMenuOptions = { "Create account" , "Login" , "LeaderBoard" } ;
        String[] mainMenuOptions = { "Play" , "Profile" , "Shop" } ;
        String[] profileMenuOptions = { "Change" , "Delete" , "Rename" , "Create" , "Show" } ;
        String[] playMenuOptions = { "Day" , "Water" , "Rail" , "Zombie" , "PvP"} ;
        String[] collectionMenuOptions = { "Show hand" , "Show collection" , "Select" , "Remove" , "Play" } ;
        String[] shopMenuOption = { "Show shop" , "Show collection" , "Buy" , "Money" } ;

        List <String> options ;
        switch ( menuStatus ){
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
