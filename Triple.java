public class Triple extends GameMode2 {
    public String[][] deck = {
            {"Thresh","Lulu","Leona","Caitlyn","Anivia","Yasuo"},
            {"Jax","Irelia","Renekton","Ashe","Master Yi","Teemo"},
            {"Thresh","Lulu","Leona","Caitlyn","Anivia","Yasuo"},
            {"Jax","Irelia","Renekton","Ashe","Master Yi","Teemo"},
            {"Thresh","Lulu","Leona","Caitlyn","Anivia","Yasuo"},
            {"Jax","Irelia","Renekton","Ashe","Master Yi","Teemo"}};
    public Triple() {

    }

    public String[][] getDeck() {
        return deck;
    }

    public void setDeck(String[][] deck) {
        this.deck = deck;
    }
}
