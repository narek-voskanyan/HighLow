package HighLow;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StartGame {
    ArrayList<GamingCards> gameCart = CardsValue.getCards();
    Scanner in = new Scanner(System.in);

    //to create the player object
    private Player getInfo() {
        //the player name
        System.out.println("Please enter your name");
        String name = in.nextLine();

        //Check the user age
        System.out.println("Please enter your age");
        int age = in.nextInt();
        if(age <= 21){
            System.out.println("Sorry, but you are so young. Come back when you grow up.");
            System.exit(0);
        }

        //the player cash
        System.out.println("Please enter how much money you would like to get");
        int cash = in.nextInt();

        //the player object return
        return new Player(name, age, cash);
    }

    public void Start(){
        Player user = getInfo();
        double bitOnCash = 0;
        System.out.println("Good day " + user.getName() + " and good luck");


            String answer;
         while(true){
             Collections.shuffle(gameCart);
             ArrayList<GamingCards> forGame = gameCart;
             one:
             while(true) {
                 System.out.println("Enter how much you would like to bid on game");
                 bitOnCash = in.nextInt();
                 if (bitOnCash > user.checkCash()) {
                     System.out.println("Sorry, you have not so much, you have only " + user.checkCash());
                     continue one;
                 }
                 break;
             }

             to:
             while(true) {
                 System.out.println("----------" + forGame.get(forGame.size() - 1).getName() + "----------");
                 System.out.println("Next cart High put <H> | Next cart Low put <L>");
                 answer = in.next();
                 answer = answer.toLowerCase();

                    // start game
                    if(answer.equals("h")){
                        if(forGame.get(forGame.size() - 1).getStatus()
                                < forGame.get(forGame.size() - 2).getStatus()){
                            bitOnCash = bitOnCash * forGame.get(forGame.size() - 1).SetUpCoefficient();
                            forGame.remove(forGame.size() - 1);

                            System.out.println(bitOnCash);
                            continue to;
                        }else {
                            System.out.println("Sorry you loss ");
                            System.exit(0);
                        }
                    }else if(answer.equals("l")){
                        if(forGame.get(forGame.size() - 1).getStatus()
                                > forGame.get(forGame.size() - 2).getStatus()){
                            bitOnCash = bitOnCash * forGame.get(forGame.size() - 1).SetDownCoefficient();
                            forGame.remove(forGame.size() - 1);

                            System.out.println(bitOnCash);
                            continue to;
                        }else{
                            System.out.println("Sorry you loss ");

                            System.exit(0);
                        }
                    }
                    // end game


             }
         }

    }
}
