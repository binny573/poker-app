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
	
	public static final List<Card> hand1 = List.of(
			new Card(CardSuit.H, CardValue.TWO), 
			new Card(CardSuit.H, CardValue.THREE), new Card(CardSuit.H, CardValue.Q), 
			new Card(CardSuit.H, CardValue.SIX),new Card(CardSuit.H, CardValue.NINE)
			);

	public static final List<Card> hand2 = List.of(
			new Card(CardSuit.C, CardValue.TWO), 
			new Card(CardSuit.C, CardValue.THREE), new Card(CardSuit.D, CardValue.Q), 
			new Card(CardSuit.D, CardValue.SIX),new Card(CardSuit.H, CardValue.EIGHT)
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
		//System.out.println(hand1);
		/* Traversing the loops*/
//		for (Card c : hand1) {
//			System.out.println(c.getSuit());
//		}
//		
//		for (Card c : hand2) {
//			System.out.println(c.getValue());
//		}
		
		/* Making comprisons between hands*/
//		int i = 0;
//		for (Card c1 : hand1) {
//			for (Card c2 : hand2) {
//				if (c1.getSuit()==c2.getSuit()) {
//					System.out.println(c1.getSuit());
//					i = i+1;
//				}
//			}			
//		}
//		System.out.println(i);
		EvaluateHands evaluateHands = new EvaluateHands(hand1, hand2, numberOfHandCards);
		evaluateHands.determineWinner();
		 

	}

}
