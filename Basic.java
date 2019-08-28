public class Basic extends GameMode1 {
    public String[][] deck = {
            {"Thresh","Lulu","Leona","Caitlyn","Anivia","Yasuo"},
            {"Jax","Irelia","Renekton","Ashe","Master Yi","Teemo"},
            {"Thresh","Lulu","Leona","Caitlyn","Anivia","Yasuo"},
            {"Jax","Irelia","Renekton","Ashe","Master Yi","Teemo"}};
    public Basic() {
    }


    public String[][] getDeck() {
        return deck;
    }

    public void setDeck(String[][] deck) {
        this.deck = deck;
    }
}
