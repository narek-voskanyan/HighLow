package HighLow;

public class GamingCards {
    GamingCards(String name, double up, double down ){
        this.name = name;
        this.up = up;
        this.down = down;
    }

    public double SetUpCoefficient(){
        return up;
    }

    public double SetDownCoefficient(){
        return down;
    }

    private double up;
    private double down;
    private String name;
}
