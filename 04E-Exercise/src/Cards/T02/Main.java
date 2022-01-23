package Cards.T02;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRank card : CardRank.values())
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
    }
}
