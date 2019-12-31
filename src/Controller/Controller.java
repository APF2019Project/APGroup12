package Controller;

import Models.Card;
import Models.Profile;
import View.View;


import java.util.* ;


public class Controller {
    public View view = new View() ;

    public static Profile getNewProfile(String username , String password ){
        return ( new Profile( username ,  password )) ;
    }

    public static void printArrayList( ArrayList<Card> arrayList ){
        for (Card card : arrayList) {
            System.out.println( card.getName());
        }
    }
    public static boolean usernameExists( String username ){
        for (Profile p : Profile.getAllProfiles()) {
            if( p.getUsername().equalsIgnoreCase( username )){
                System.out.println("This username is already exist! Enter another one ...");
                return true ;
            }
        }
        return false ;
    }



    public void gameHandle(){
        view.loginMenu();

    }



}
