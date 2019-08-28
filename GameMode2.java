import java.util.Random;

public class GameMode2 {
    public int i;
    public int j;
    public String[][] deck;

    public GameMode2(int i, int j, String[][] deck) {
        this.i = i;
        this.j = j;
        this.deck = deck;
    }

    public GameMode2() {

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String[][] getDeck() {
        return deck;
    }

    public String getCard(int a, int b) {
        return deck[a][b];
    }

    public void setDeck(String[][] deck) {
        this.deck = deck;
    }

    public int chooseCard(int matchPar, int a, int b, int c, int d, int e, int f) {
        System.out.println("First card was: "+deck[a][b] + "\nSecond card was : " + deck[c][d]+"\nThird card was: "+ deck[e][f]);
        if (deck[a][b].equals(deck[c][d]) && deck[c][d].equals(deck[e][f])) {
            deck[a][b] = "_";
            deck[c][d] = "_";
            deck[e][f] = "_";
            matchPar++;
            System.out.println("Good Job! You found a match!");
        } else {
            System.out.println("Ooooh bad luck! Try again!");
        }
        return matchPar;
    }

    public void matrixAlter(int a, int b, int c, int d, int e, int f) {
        if (deck[a][b].equals(deck[c][d]) && deck[c][d].equals(deck[e][f])) {
            deck[a][b] = "_";
            deck[c][d] = "_";
            deck[e][f] = "_";
        }
    }
    public void printMatrix () {
        for (int i = 0; i < deck.length; i++) {
            for (int j = 0; j < deck[i].length; j++) {
                System.out.print(deck[i][j] + " ");
            }
            System.out.println();
        }
    }
    public String[][] shuffle(String[][] a) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                String temp = a[i][j];
                a[i][j] = a[m][n];
                a[m][n] = temp;
            }
        }
        return a;
    }
}

