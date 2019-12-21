package Models;

import java.util.ArrayList;

public class Account {
    private String username ;
    private String  password ;
    private int outerCoins ;
    private int record ;   // killed zombies
    private ArrayList<Profile> profiles = new ArrayList<>() ;
    public static Account currentAccount ;
    private static ArrayList<Account> allAccounts = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        allAccounts.add(this);
    }

    public static Account getAccountObj (String username , String password ){
        for ( Account acc : allAccounts ) {
            if( acc.username.equalsIgnoreCase(username) && acc.password.equalsIgnoreCase(password))
                return acc ;
        }
        return null ;
    }
    public Profile getProfileObj (String username , String password ){
        for ( Profile p : profiles ) {
            if( p.getUsername().equalsIgnoreCase(username) && p.getPassword().equalsIgnoreCase(password))
                return p ;
        }
        return null ;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getOuterCoins() { return outerCoins; }
    public void setOuterCoins(int outerCoins) { this.outerCoins = outerCoins; }
    public int getRecord() { return record; }
    public void setRecord(int record) { this.record = record; }
    public static ArrayList<Account> getAllAccounts() { return allAccounts; }
    public static void setAllAccounts(ArrayList<Account> allAccounts) { Account.allAccounts = allAccounts; }
    public ArrayList<Profile> getProfiles() { return profiles; }

}
