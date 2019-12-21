package Controller;

import Models.Account;
import Models.Card;
import Models.Profile;

import java.util.* ;


public class Controller {

    public static Account getNewAccount (String username , String password ){
        return ( new Account( username ,  password )) ;
    }
    public static Profile getNewProfile( String username , String password , Account currentAccount ){
        Profile profile = new Profile( username , password ) ;
        currentAccount.getProfiles().add( profile ) ;
        return profile ;
    }
    public static void printArrayList( ArrayList<Card> arrayList ){
        for (Card card : arrayList) {
            System.out.println( card.getName());
        }
    }


}
