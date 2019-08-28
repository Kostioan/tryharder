public class TripleHidden extends GameMode2 {
    public String[][] deck = {
            {"█","█","█","█","█","█"},
            {"█","█","█","█","█","█"},
            {"█","█","█","█","█","█"},
            {"█","█","█","█","█","█"},
            {"█","█","█","█","█","█"},
            {"█","█","█","█","█","█"}};

    public TripleHidden() {
    }


    public String[][] getDeck() {
        return deck;
    }

    public void setDeck(String[][] deck) {
        this.deck = deck;
    }
}