package d3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoFishTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testGoodDrawCard() {
        GoFish.setDeck(new ArrayList<>(Collections.singletonList(Card.ACE)));
        Card card = GoFish.drawCard();
        assertNotNull(card);
        assertEquals(Card.ACE, card);
    }

    @Test
    void testBadDrawCard() {
        GoFish.setDeck(new ArrayList<>());
        Card card = GoFish.drawCard();
        assertNull(card);
    }

    @Test
    void testBoundaryGetCard() {
        GoFish.setDeck(new ArrayList<>(Arrays.asList(Card.values())));
        for (int i = 0; i < 52; i++) {
            GoFish.drawCard();
        }
        Card card = GoFish.drawCard();
        assertNull(card);
    }

    @Test
    void testGoodInitializeDeck() {
        GoFish.initializeDeck();
        assertEquals(52, GoFish.getDeck().size());
        assertTrue(GoFish.getDeck().containsAll(Arrays.asList(Card.values())));
    }

    @Test
    void testBadInitializeDeck() {
        GoFish.setDeck(null);
        GoFish.initializeDeck();
        assertNotNull(GoFish.getDeck());
    }

    @Test
    void testBoundaryInitializeDeck() {
        GoFish.setDeck(new ArrayList<>(Arrays.asList(Card.ACE)));
        GoFish.initializeDeck();
        assertEquals(52, GoFish.getDeck().size());
        assertTrue(GoFish.getDeck().containsAll(Arrays.asList(Card.values())));
    }

    @Test
    void testSetDeckGood() {
        ArrayList<Card> deck = new ArrayList<>();
        deck.add(Card.ACE);
        deck.add(Card.KING);
        GoFish.setDeck(deck);
        assertEquals(deck, GoFish.getDeck());
    }

    @Test
    void testSetDeckBad() {
        GoFish.setDeck(null);
    }

    @Test
    void testSetDeckBoundary() {
        ArrayList<Card> deck = new ArrayList<>();
        GoFish.setDeck(deck);
        assertEquals(deck, GoFish.getDeck());
    }

}
