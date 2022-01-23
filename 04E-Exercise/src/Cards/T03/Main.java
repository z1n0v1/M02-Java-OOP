package Cards.T03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank card = CardRank.valueOf(scanner.nextLine());
        CardSuit suit = CardSuit.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d%n",
                card, suit, card.getValue() + suit.getValue());
    }
}
