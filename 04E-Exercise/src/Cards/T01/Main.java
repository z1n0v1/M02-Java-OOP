package Cards.T01;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (CardSuit card : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
        }
    }
}
