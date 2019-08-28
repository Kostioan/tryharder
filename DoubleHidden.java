public class DoubleHidden extends GameMode1 {
    public String[][] deck = {
            {"█","█","█","█","█","█","█","█"},
            {"█","█","█","█","█","█","█","█"},
            {"█","█","█","█","█","█","█","█"},
            {"█","█","█","█","█","█","█","█"},
            {"█","█","█","█","█","█","█","█"},
            {"█","█","█","█","█","█","█","█"}};

    public DoubleHidden() {
    }


    public String[][] getDeck() {
        return deck;
    }

    public void setDeck(String[][] deck) {
        this.deck = deck;
    }
}