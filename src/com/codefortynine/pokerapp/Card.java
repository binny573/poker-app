package com.codefortynine.pokerapp;

import java.util.List;

public class Card {
	
	private CardSuit suit;
	private CardValue value;
	private static final int numberOfHandCards = 5;
	
	public Card(CardSuit suit, CardValue value) {
		super();
		this.suit = suit;
		this.value = value;
	}
/*
 * hand1 and hand2 can be directly manipulated to check business logic and test results
 */
	public static List<Card> hand1 = List.of(
			new Card(CardSuit.H, CardValue.SEVEN),
			new Card(CardSuit.H, CardValue.FOUR),
			new Card(CardSuit.H, CardValue.EIGHT), 
			new Card(CardSuit.S, CardValue.K),
			new Card(CardSuit.H, CardValue.Q)
			);

	public static List<Card> hand2 = List.of(
			new Card(CardSuit.S, CardValue.SEVEN),
			new Card(CardSuit.S, CardValue.EIGHT),
			new Card(CardSuit.H, CardValue.TWO),
			new Card(CardSuit.S, CardValue.Q),
			new Card(CardSuit.S, CardValue.K)
			);
	
	public CardSuit getSuit() {
		return suit;
	}
	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}
	public CardValue getValue() {
		return value;
	}
	public void setValue(CardValue value) {
		this.value = value;
	}

	public static void main(String [] args) {

		EvaluateHands evaluateHands = new EvaluateHands(hand1, hand2, numberOfHandCards);
		String result = evaluateHands.determineWinner();
		System.out.println(result);
	}
}

