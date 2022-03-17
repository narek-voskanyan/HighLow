package HighLow;

import java.util.Collections;
import java.util.ArrayList;

public class StartGame {
    ArrayList<GamingCards> gameCart = CardsValue.getCards();


    public void TheGameIsStarting(){
        Collections.shuffle(gameCart);
    }
}
