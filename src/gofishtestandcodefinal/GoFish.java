package d3;

import java.util.ArrayList;
import java.util.Random;

public class GoFish {
    private static final Random random = new Random();
    private static ArrayList<Card> deck;
    static AbstractPlayer[] players;

    public static void main(String[] args) {
        initializeDeck();
        players = new AbstractPlayer[]{new HumanPlayer(), new ComputerPlayer()};
        playGame();
    }

    // Initialize the deck with a standard set of cards
    static void initializeDeck() {
        setDeck(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            for (Card c : Card.values()) {
                getDeck().add(c);
            }
        }
    }

    // Main game loop
    static void playGame() {
        while (players[0].getBookCount() + players[1].getBookCount() < 13) {
            for (AbstractPlayer player : players) {
                player.takeTurn();
                System.out.println("----------");
            }
        }

        int humanScore = players[0].getBookCount();
        int computerScore = players[1].getBookCount();

        // Determine and display the winner or a tie
        if (humanScore > computerScore) {
            System.out.println("Congratulations, you win " + humanScore + " to " + computerScore + "!");
        } else if (computerScore > humanScore) {
            System.out.println("The AI beat you " + computerScore + " to " + humanScore + ".");
        } else {
            System.out.println("It's a tie at " + humanScore + " each!");
        }
    }

    // Draw a card from the deck
    public static Card drawCard() {
        if (getDeck().isEmpty()) {
            return null;
        }
        return getDeck().remove(random.nextInt(getDeck().size()));
    }

    // Getters and setters
    public static ArrayList<Card> getDeck() {
        return deck;
    }

    public static void setDeck(ArrayList<Card> deck) {
        GoFish.deck = deck;
    }
}
