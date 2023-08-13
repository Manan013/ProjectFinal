package d3;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void takeTurn() {
        System.out.println("Your hand: " + hand);

        while (true) {
            System.out.print("Enter the name of the card you'd like to request from the opponent: ");
            String input = scanner.next().toUpperCase();

            try {
                Card requestedCard = Card.valueOf(input);

                if (!hand.contains(requestedCard)) {
                    System.out.println("You must have the requested card in your hand. Try again.");
                    continue;
                }

                Card receivedCard = requestCard(GoFish.players[1], requestedCard);
                if (receivedCard != null) {
                    System.out.println("You received a " + receivedCard + " from your opponent.");
                    checkForBooks();
                } else {
                    System.out.println("Your opponent does not have a " + requestedCard + ". Go Fish!");
                    draw();
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid card name. Try again.");
            }
        }
    }
}
