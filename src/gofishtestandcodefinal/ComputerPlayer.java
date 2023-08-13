package d3;

import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    private Random random = new Random();

    @Override
    public void takeTurn() {
        while (true) {
            // Select a card randomly from the AI's hand
            Card selectedCard = hand.get(random.nextInt(hand.size()));
            System.out.println("The AI is asking for a " + selectedCard);

            // Request a card from the human player
            Card receivedCard = requestCard(GoFish.players[0], selectedCard);
            
            // Handle the outcome of the request
            if (receivedCard != null) {
                System.out.println("The AI successfully received a " + receivedCard + " from you.");
                checkForBooks();
            } else {
                System.out.println("The AI's request was unsuccessful. Go Fish!");
                draw();
                break;
            }
        }
    }
}
