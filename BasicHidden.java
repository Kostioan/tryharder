public class BasicHidden extends GameMode1 {
    public String[][] deck = {{"█","█","█","█","█","█"},{"█","█","█","█","█","█"},{"█","█","█","█","█","█"},{"█","█","█","█","█","█"}};

    public BasicHidden() {
    }


    public String[][] getDeck() {
        return deck;
    }

    public void setDeck(String[][] deck) {
        this.deck = deck;
    }
}
