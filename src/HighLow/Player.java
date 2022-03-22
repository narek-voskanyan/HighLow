package HighLow;

public class Player {
    Player(String name, int age, int cash){
        this.name = name;
        this.age = age;
        this.cash = cash;
    }

    // Check user status
    public void checkUserStatus(){
        if(this.cash == 0){
            System.out.println("Sorry, but you lost all your money");
            System.exit(0);
        }
    }

    //to check the user available to bid so much cash
    public long checkCash(){
        return this.cash;
    }
    public String getName(){
        return name;
    }

    public void plusWinCash(double outCash){
        this.cash += (int) outCash;
    }

    public void minusLossCash(double outCash){
        this.cash -= (int) outCash;
    }
    private final  String name;
    private long cash;
    private final int age;
}
