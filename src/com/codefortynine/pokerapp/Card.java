package com.codefortynine.pokerapp;

import java.util.List;

public class Card {
	
	private CardSuit suit;
	private CardValue value;
	
	public static final List<Card> hand1 = List.of(
			new Card(CardSuit.C, CardValue.TWO), 
			new Card(CardSuit.H, CardValue.THREE), new Card(CardSuit.D, CardValue.Q), 
			new Card(CardSuit.C, CardValue.SIX),new Card(CardSuit.H, CardValue.NINE)
			);

	public static final List<Card> hand2 = List.of(
			new Card(CardSuit.C, CardValue.TWO), 
			new Card(CardSuit.H, CardValue.THREE), new Card(CardSuit.D, CardValue.Q), 
			new Card(CardSuit.C, CardValue.SIX),new Card(CardSuit.H, CardValue.NINE)
			);
	
	public Card(CardSuit suit, CardValue value) {
		super();
		this.suit = suit;
		this.value = value;
	}
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
		//System.out.println(hand1);
		for (Card c : hand1) {
			System.out.println(c.getSuit());
		}
		
		for (Card c : hand2) {
			System.out.println(c.getValue());
		}
		
	}

}
