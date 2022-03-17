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
            System.out.println("You lost all your money");
            System.exit(0);
        }
    }

    //to check the user available to bid so much cash
    public int checkCash(){
        return this.cash;
    }


    private final  String name;
    private int age;
    private int cash;
}
