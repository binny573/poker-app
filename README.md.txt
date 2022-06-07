HIGHER LEVEL UNDERSTANDING OF THE POKER APP

--I have assigned Card Values weights that are basically the indexes of the Lists ie (TWO, THREE,...A) are (0, 1, ... ,11,12) with 12 being highest value.
Weights were assigned to the values after fetching index of the values in the arraylists for then CardValues from the listofPosssibleCardValues.
The basic ideas of comparing higher and lower values is with the help of these weights

--After initialzing base classes. The Poker hands were developed from highest to lowest Poker Hands (Straight flush, Four of a Kind, ..., High Card).

--Running the Card.java main method gives you the result as well as the message about which Poker hand was used to determine the winner in the console.
Note: - When a hand wins with methods like flush (), since high card rules also apply, there will be two messages.

--Maps, ArrayLists and Sets have been used throught for they're specific properties.

--CountWeight.java was used as the value to be build keyCountWeightMap that was initially designed to simultaneously store counts of the keys and their weight.

--The initial assumption was to create a single Map that could have multipurpose use. However, as the Poker hands were developed from highest to lowest(),
it was realized that it was simpler to send Sets/Lists/ Simpler Maps directly to the PokerHands.java class from the EvaluateHands.java
class.

--Methods were used as much as possible throughtout, to express maximum logic with minimal code

--Leftover Comments not being a good practice have been mostly removed. 

ENUMS are declared as 

public enum CardSuit {
	C,
	D,
	H,
	S
}

public enum CardValue {
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	T,
	J,
	Q,
	K,
	A	
}
* CarValue.T stands for Ten

