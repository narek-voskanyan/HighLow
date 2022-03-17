package HighLow;

public class GamingCards {
    GamingCards(String name, double up, double down, int status ){
        this.name = name;
        this.up = up;
        this.down = down;
        this.status = status;
    }

    public double SetUpCoefficient(){
        return up;
    }

    public double SetDownCoefficient(){
        return down;
    }

    public int getStatus(){
        return status;
    }
    public String getName(){
        return this.name;
    }
    private final int status;
    private final double up;
    private final double down;
    private final String name;
}