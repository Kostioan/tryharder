import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String playerName = "Default";
        int counter = 1;
        int trapCounterA=0, trapCounterB=0, trapCounterC=0, trapCounterD=0, trapCounterE=0,trapCounterF=0;
        int i=0, j=0, matchPar=0, steps=0;
        int mode=0;
        System.out.println("Welcome to Memory Game! Please enter your username!(up to 16 characters, let's keep it practical)");
        Scanner scan = new Scanner(System.in);
        do {
            playerName = scan.nextLine();
            if (playerName.length() > 16) {
                System.out.println("Invalid input. Too many letters. Please type a valid username.");
            }
            if (playerName.length() == 0) {
                System.out.println("Just put a name.");
                playerName = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            }

        }
        while (playerName.length() > 16);
        String tempPlayerName = playerName;
        if (playerName.contains(" ")) {
            playerName = tempPlayerName.replace(" ", "_");

        }
        System.out.println("Hello " + playerName.substring(0, 1).toUpperCase() + playerName.substring(1) + ". Please choose one of the following game modes , by typing the corresponding number. ");
        System.out.println("1. Basic  : 2 copies of 12 cards");
        System.out.println("2. Double : 2 copies of 24 cards");
        System.out.println("3. Triple : 3 copies of 12 cards");
        String gameMode = "";
        do {
            gameMode = scan.nextLine();
            if (!(gameMode.equals("1")) && !(gameMode.equals("2")) && !(gameMode.equals("3"))) {
                System.out.println("Invalid game mode selection. Please enter a valid game mode from the 3 choices above. (1-2-3)");
            }
        }
        while (!(gameMode.equals("1")) && !(gameMode.equals("2")) && !(gameMode.equals("3")));
        GameMode1 deck = new GameMode1();
        GameMode1 deckH = new GameMode1();
        GameMode2 decK = new GameMode2();
        GameMode2 decKH = new GameMode2();
        switch (gameMode) {
            case "1": {
                System.out.println("Game mode set to Basic. Let's begin and good luck!");
                Basic basicDeck = new Basic();
                deck = new GameMode1(3, 5, basicDeck.getDeck());
                BasicHidden hiddenDeck = new BasicHidden();
                deckH = new GameMode1(3,5,hiddenDeck.getDeck());
                counter = 12;
                i= 4;
                j= 6;
                mode=1;
                break;
            }
            case "2": {
                System.out.println("Game mode set to Double. Let's begin and good luck!!");
                Double doubleDeck = new Double();
                deck = new GameMode1(5, 7, doubleDeck.getDeck());
                DoubleHidden hiddenDeck = new DoubleHidden();
                deckH = new GameMode1(5,7,hiddenDeck.getDeck());
                counter = 24;
                i = 6;
                j = 8;
                mode=1;
                break;
            }
            case "3": {
                System.out.println("Game mode set to Triple!!!. Let's begin and good luck!!!");
                Triple tripleDeck = new Triple();
                decK = new GameMode2(5, 5, tripleDeck.getDeck());
                TripleHidden hiddenDeck = new TripleHidden();
                decKH = new GameMode2(5,5,hiddenDeck.getDeck());
                counter = 18;
                i = 6;
                j = 6;
                mode=2;
                break;
            }
        }
        int endCounter=0;
        int a,b,c,d,e,f;

        if(mode==1){
            deck.setDeck(deck.shuffle(deck.getDeck()));
        System.out.println("The rules are simple. Each time you have to give 4 inputs matching the row and the column of the 2 cards you want to choose.\n"+
                "EX. I want to choose the card in row 3 column 3. I input 3, hit enter, then hit another 3, hit enter.\n" +
                "Then i want to choose the card in row 2 column 1. I input 2, hit enter, then hit 1 and hit enter. The game will compare these 2 cards.\n");
        deckH.printMatrix();
        do{
            System.out.println("Choose 2 cards");
            do{
                a = scan.nextInt();
                if (a<1 || a>i){
                    System.out.println("Incorrect input.Please put a number between 1 and "+i);
                }
                if( (trapCounterA==j && a==1) || (trapCounterB==j && a==2) || (trapCounterC==j && a==3) || (trapCounterD==j && a==4) || (trapCounterE==j && a==5) || (trapCounterF==j && a==6)){
                    System.out.println("This row doesn't have any more cards to choose from! Please choose another row!");
                }
            }while (a<1 || a>=i+1 || (trapCounterA==j && a==1) || (trapCounterB==j && a==2) || (trapCounterC==j && a==3) || (trapCounterD==j && a==4) || (trapCounterE==j && a==5) || (trapCounterF==j && a==6) );
            System.out.println("First card:");
            System.out.println("Row : "+a);
            do{
                b = scan.nextInt();
                if((b<1) || (b>j)){
                    System.out.println(("Incorrect input.Please put a number between 1 and "+j));
                }
                if(deck.getCard(a-1,b-1).equals("_")){
                    System.out.println("You can't choose the same card twice. Please choose another card.");
                }
            }while((b<1 || b>=j+1) || deck.getCard(a-1,b-1).equals("_"));
            System.out.println("Column : "+b);
            System.out.println(deck.getCard(a-1,b-1));
            System.out.println("Second card: ");
            do{
                c = scan.nextInt();
                if (c<1 || c>i){
                    System.out.println("Incorrect input.Please put a number between 1 and "+i);
                }
                if( (trapCounterA==j && c==1) || (trapCounterB==j && c==2) || (trapCounterC==j && c==3) || (trapCounterD==j && c==4) || (trapCounterE==j && c==5) || (trapCounterF==j && c==6)){
                    System.out.println("This row doesn't have any more cards to choose from! Please choose another row!");
                }
            }while (c<1 || c>=i+1 || (trapCounterA==j && c==1) || (trapCounterB==j && c==2) || (trapCounterC==j && c==3) || (trapCounterD==j && c==4) || (trapCounterE==j && c==5) || (trapCounterF==j && c==6) );
            System.out.println("Row: "+c);
            do{
                d = scan.nextInt();
                if (d<1 || d>j){
                    System.out.println("Incorrect input.Please put a number between 1 and "+j);
                }
                if(b==d && c==a){
                    System.out.println("NICE TRY BRO :D");
                }
                if(deck.getCard(c-1,d-1).equals("_")){
                    System.out.println("You can't choose the same card twice. Please choose another card.");
                }
            }while ((d<1 || d>=j+1) || ((d==b) && (c==a)) || deck.getCard(c-1,d-1).equals("_"));
            System.out.println("Row: "+d);
            System.out.println(deck.getCard(c-1,d-1));
            matchPar=deck.chooseCard(matchPar,a-1,b-1,c-1,d-1);
            if(matchPar==1){
                deckH.matrixAlter(a-1,b-1,c-1,d-1);
                matchPar=0;
                endCounter++;
                if(a==1){
                    trapCounterA++;
                }else if(a==2){
                    trapCounterB++;
                }else if(a==3){
                    trapCounterC++;
                }else if(a==4){
                    trapCounterD++;
                }else if(a==5){
                    trapCounterE++;
                }else if(a==6){
                    trapCounterF++;
                }
                if(c==1){
                    trapCounterA++;
                }else if(c==2){
                    trapCounterB++;
                }else if(c==3){
                    trapCounterC++;
                }else if(c==4){
                    trapCounterD++;
                }else if(c==5){
                    trapCounterE++;
                }else if(c==6) {
                    trapCounterF++;
                }
            }
            deckH.printMatrix();
            steps++;
            if(endCounter == counter){
                System.out.println("Congratulations!!! You beat the game in " +steps+" steps.");
            }
        }while (endCounter != counter);

    }
        if(mode==2){
            decK.setDeck(decK.shuffle(decK.getDeck()));
            System.out.println("The rules are simple. Each time you pick a total of 3 cards, so you have to give a total of 6 inputs, each one matching the row and the column of the card you want to pick!\nEX. Let's say i want to pick the card at row 1 column 1, the card at row 3 column 4 and the card at row 6 column 6. \n I will put 1 followed by enter, then 1. Then i will hit 3, enter, 4. And lastly i will hit 6,enter and 6 again.");
            decKH.printMatrix();
            do{
                System.out.println("Choose 3 cards");
                do{
                    a = scan.nextInt();
                    if (a<1 || a>i){
                        System.out.println("Incorrect input.Please put a number between 1 and "+i);
                    }
                    if( (trapCounterA==j && a==1) || (trapCounterB==j && a==2) || (trapCounterC==j && a==3) || (trapCounterD==j && a==4) || (trapCounterE==j && a==5) || (trapCounterF==j && a==6)){
                        System.out.println("This row doesn't have any more cards to choose from! Please choose another row!");
                    }
                }while (a<1 || a>=i+1 || (trapCounterA==j && a==1) || (trapCounterB==j && a==2) || (trapCounterC==j && a==3) || (trapCounterD==j && a==4) || (trapCounterE==j && a==5) || (trapCounterF==j && a==6) );
                System.out.println("First card:");
                System.out.println("Row : "+a);
                do{
                    b = scan.nextInt();
                    if((b<1) || (b>j)){
                        System.out.println(("Incorrect input.Please put a number between 1 and "+j));
                    }
                    if(decK.getCard(a-1,b-1).equals("_")){
                        System.out.println("You can't choose the same card twice. Please choose another card.");
                    }
                }while((b<1 || b>=j+1) || decK.getCard(a-1,b-1).equals("_"));
                System.out.println("Column : "+b);
                System.out.println(decK.getCard(a-1,b-1));
                System.out.println("Second card: ");
                do{
                    c = scan.nextInt();
                    if (c<1 || c>i){
                        System.out.println("Incorrect input.Please put a number between 1 and "+i);
                    }
                    if( (trapCounterA==j && c==1) || (trapCounterB==j && c==2) || (trapCounterC==j && c==3) || (trapCounterD==j && c==4) || (trapCounterE==j && c==5) || (trapCounterF==j && c==6)){
                        System.out.println("This row doesn't have any more cards to choose from! Please choose another row!");
                    }
                }while (c<1 || c>=i+1 || (trapCounterA==j && c==1) || (trapCounterB==j && c==2) || (trapCounterC==j && c==3) || (trapCounterD==j && c==4) || (trapCounterE==j && c==5) || (trapCounterF==j && c==6) );
                System.out.println("Row: "+c);
                do{
                    d = scan.nextInt();
                    if (d<1 || d>j){
                        System.out.println("Incorrect input.Please put a number between 1 and "+j);
                    }
                    if(b==d && c==a){
                        System.out.println("NICE TRY BRO :D");
                    }
                    if(decK.getCard(c-1,d-1).equals("_")){
                        System.out.println("You can't choose the same card twice. Please choose another card.");
                    }
                }while ((d<1 || d>=j+1) || ((d==b) && (c==a)) || decK.getCard(c-1,d-1).equals("_"));
                System.out.println("Column: "+d);
                System.out.println(decK.getCard(c-1,d-1));
                System.out.println("Third Card : ");
                do{
                    e = scan.nextInt();
                    if (e<1 || e>i){
                        System.out.println("Incorrect input.Please put a number between 1 and "+i);
                    }
                    if( (trapCounterA==j && e==1) || (trapCounterB==j && e==2) || (trapCounterC==j && e==3) || (trapCounterD==j && e==4) || (trapCounterE==j && e==5) || (trapCounterF==j && e==6)){
                        System.out.println("This row doesn't have any more cards to choose from! Please choose another row!");
                    }
                }while (e<1 || e>=i+1 || (trapCounterA==j && e==1) || (trapCounterE==j && e==2) || (trapCounterC==j && e==3) || (trapCounterD==j && e==4) || (trapCounterE==j && e==5) || (trapCounterF==j && e==6) );
                System.out.println("Row : "+e);
                do{
                    f = scan.nextInt();
                    if (f<1 || f>j){
                        System.out.println("Incorrect input.Please put a number between 1 and "+j);
                    }
                    if(f==d && f==a){
                        System.out.println("NICE TRY BRO :D");
                    }
                    if(decK.getCard(e-1,f-1).equals("_")){
                        System.out.println("You can't choose the same card twice. Please choose another card.");
                    }
                }while ((f<1 || f>=j+1) || ((f==b) && (e==a)) || decK.getCard(e-1,f-1).equals("_"));
                matchPar=decK.chooseCard(matchPar,a-1,b-1,c-1,d-1, e-1, f-1);
                if(matchPar==1){
                    decKH.matrixAlter(a-1,b-1,c-1,d-1, e-1, f-1);
                    matchPar=0;
                    endCounter++;
                    if(a==1){
                        trapCounterA++;
                    }else if(a==2){
                        trapCounterB++;
                    }else if(a==3){
                        trapCounterC++;
                    }else if(a==4){
                        trapCounterD++;
                    }else if(a==5){
                        trapCounterE++;
                    }else if(a==6){
                        trapCounterF++;
                    }
                    if(c==1){
                        trapCounterA++;
                    }else if(c==2){
                        trapCounterB++;
                    }else if(c==3){
                        trapCounterC++;
                    }else if(c==4){
                        trapCounterD++;
                    }else if(c==5){
                        trapCounterE++;
                    }else if(c==6) {
                        trapCounterF++;
                    }
                    if(e==1){
                        trapCounterA++;
                    }else if(e==2){
                        trapCounterB++;
                    }else if(e==3){
                        trapCounterC++;
                    }else if(e==4){
                        trapCounterD++;
                    }else if(e==5){
                        trapCounterE++;
                    }else if(e==6) {
                        trapCounterF++;
                    }
                }
                decKH.printMatrix();
                steps++;
                if(endCounter == counter){
                    System.out.println("Congratulations!!! You beat the game in " +steps+" steps.");
                }
            }while (endCounter != counter);
        }
    }
}
