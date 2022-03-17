package HighLow;

import java.util.Collections;
import java.util.LinkedList;

public class StartGame {
    LinkedList<GamingCards> gameCart = CardsValue.getCards();

    public  void getGame(){
        Collections.shuffle(gameCart);
        
    }
}
