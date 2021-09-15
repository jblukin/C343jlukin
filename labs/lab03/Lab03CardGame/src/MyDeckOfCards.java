import java.util.ArrayList;

public class MyDeckOfCards implements DeckADT {
	
	private ArrayList<String> deck = new ArrayList<String>();
	
	public void initialize() {
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				if (j < 10) {
					if (i == 0) {
						deck.add("S" + j);
					} else if (i == 1) {
						deck.add("C" + j);
					} else if (i == 2) {
						deck.add("H" + j);
					} else {
						deck.add("D" + j);
					}
				} else if (j == 10) {
					if (i == 0) {
						deck.add("SJ");
					} else if (i == 1) {
						deck.add("CJ");
					} else if (i == 3) {
						deck.add("HJ");
					} else {
						deck.add("DJ");
					}
				} else if (j == 11) {
					if (i == 0) {
						deck.add("SQ");
					} else if (i == 1) {
						deck.add("CQ");
					} else if (i == 2) {
						deck.add("HQ");
					} else {
						deck.add("DQ");
					}
				} else if (j == 12) {
					if (i == 0) {
						deck.add("SK");
					} else if (i == 1) {
						deck.add("CK");
					} else if (i == 2) {
						deck.add("HK");
					} else {
						deck.add("DK");
					}
				} else if (j == 13) {
					if (i == 0) {
						deck.add("SA");
					} else if (i == 1) {
						deck.add("CA");
					} else if (i == 2) {
						deck.add("HA");
					} else {
						deck.add("DA");
					}
				}
			}
		}
		
	}
	
	public String drawRandomCard() {
		
		return deck.get((int)(Math.random()*52));
		
	}
	
	public void pushCardToBottomOfDeck(String remove) {
		
		for (String card: deck) {
			if(card.equals(remove))
			deck.remove(card);
			deck.add(52, card);
		}
	
	}
	
	public String drawTopCardFromDeck() {
		return deck.get(0);
	}
	
	public String toString() {
		return "" + deck;
	}
	
	public static void main(String[] args) {
		
		MyDeckOfCards deck1 = new MyDeckOfCards();
		MyDeckOfCards deck2 = new MyDeckOfCards();
		
		
		
		//Should be the same and empty
		System.out.println("Deck1: " + deck1);
		System.out.println("Deck2: " + deck2);
		
		//Initializes identical decks
		deck1.initialize();
		deck2.initialize();
		
		//Should be the same and full
		System.out.println("Deck1: " + deck1);
		System.out.println("Deck2: " + deck2);

		//1 in 52 chance they are same
		System.out.println("Deck1 drawRandomCard: " + deck1.drawRandomCard());
		System.out.println("Deck2 drawRandomCard: " + deck2.drawRandomCard());
		
		//Should both be "S1"
		System.out.println("Deck1 drawTopCardFromDeck: " + deck1.drawTopCardFromDeck());
		System.out.println("Deck2 drawTopCardFromDeck: " + deck2.drawTopCardFromDeck());
		
	}
	
}
