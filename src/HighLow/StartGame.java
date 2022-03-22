package HighLow;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class StartGame {

    Scanner in = new Scanner(System.in);

    //start to create the player object
    private Player getInfo() {
        //the player name
        System.out.println("Please enter your name");
        String name = in.nextLine();

        //Check the user age
        System.out.println("Please enter your age");
        int age = in.nextInt();
        if(age < 21){
            System.out.println("Sorry, but you are so young. Come back when you grow up.");
            System.exit(0);
        }

        //the player cash
        System.out.println("Please enter how much money you would like to get");
        int cash = in.nextInt();

        //the player object return
        return new Player(name, age, cash);
    }
    // finish the created the player object


    public void Start(){
        Player user = getInfo();

        String answer;
        double bitOnCash;
        System.out.println("Good day " + user.getName() + " and good luck");

        //new game start
            start:
         while(true){

             ArrayList<GamingCards> forGame = CardsValue.getCards();
             Collections.shuffle(forGame);


             //start check the user available to bid or not
             while(true) {
                 System.out.println("Enter how much you would like to bid on game");
                 bitOnCash = in.nextInt();
                 if (bitOnCash > user.checkCash()) {
                     System.out.println("Sorry, you have not so much, you have only " + user.checkCash());

                 }else{
                     user.minusLossCash(bitOnCash);
                     break;
                 }
             }
             // finish check the user available to bid or not

             // start playing
             while(true) {

                 if(forGame.size() == 1){
                     user.plusWinCash(bitOnCash);
                     System.out.println("The cards were over, you have  " + user.checkCash() + " $");
                     continue start;
                 }

                 System.out.println("---------- " + forGame.get(forGame.size() - 1).getName() + " ----------");
                 System.out.println("----------> " + forGame.get(forGame.size() - 2).getName() + " --> " + forGame.size() );

                 System.out.println("Next cart High press <H> | Next cart Low press <L> \n " +
                         "If you want to finish game press <F> | If you want cash out press <C>" );
                 answer = in.next();
                 answer = answer.toLowerCase();


                 switch (answer) {
                     case "h":
                         // start: if the cards are same
                         if(forGame.get(forGame.size() - 1).getStatus()
                                 == forGame.get(forGame.size() - 2).getStatus()){
                             forGame.remove(forGame.size() - 1);
                             System.out.println("the playing cards are same each other");
                             continue;
                         }
                            // end if the cards are same
                         if (forGame.get(forGame.size() - 1).getStatus()
                                 < forGame.get(forGame.size() - 2).getStatus()) {
                             bitOnCash = bitOnCash * forGame.get(forGame.size() - 1).SetUpCoefficient();
                             forGame.remove(forGame.size() - 1);

                             System.out.println(bitOnCash);

                         }else {
                             user.checkUserStatus();
                             System.out.println("Sorry you loss  you have " + user.checkCash() + "$ \n " +
                                     "would you like to play again? YES <Y> | NO: press the another letter");
                             String a = in.next();
                             a = a.toLowerCase();
                             if (a.equals("y")) {
                                 System.out.println("---------- NEW GAME ----------");
                                 continue start;
                             }else {
                                 System.out.println("Have a nice day");
                                 System.exit(0);
                             }
                         }
                         break;
                     case "l":
                         // start: if the cards are same
                         if(forGame.get(forGame.size() - 1).getStatus()
                                 == forGame.get(forGame.size() - 2).getStatus()){
                             forGame.remove(forGame.size() - 1);
                             System.out.println("The playing cards are same each other");
                             continue;
                         }
                         // end if the cards are same

                         if (forGame.get(forGame.size() - 1).getStatus()
                                 > forGame.get(forGame.size() - 2).getStatus()) {
                             bitOnCash = bitOnCash * forGame.get(forGame.size() - 1).SetDownCoefficient();
                             forGame.remove(forGame.size() - 1);

                             System.out.println(bitOnCash);

                         }else {
                             user.checkUserStatus();
                             System.out.println("Sorry you loss  you have " + user.checkCash() + "$ \n " +
                                     "would you like to play again? YES <Y> | NO: press the another letter");
                             String a = in.next();
                             a = a.toLowerCase();
                             if (a.equals("y")) {
                                 System.out.println("---------- NEW GAME ----------");
                                 continue start;
                             }else {
                                 System.out.println("Have a nice day");
                                 System.exit(0);
                             }
                         }
                         break;
                     case "f":
                         user.plusWinCash(bitOnCash);
                         System.out.println("Thank you for game," +
                                 " you go out from game with  " + user.checkCash() + " $");
                         System.exit(0);
                         // end game
                     case "c":
                         user.plusWinCash(bitOnCash);
                         System.out.println("Your have  " + user.checkCash() + " $");
                         continue start;
                 }

             }
             //Finish playing
         }
        // new game finish
    }
}
