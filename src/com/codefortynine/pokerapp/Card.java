package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
			new Card(CardSuit.H, CardValue.FIVE), 
			new Card(CardSuit.H, CardValue.SIX), new Card(CardSuit.H, CardValue.SEVEN), 
			new Card(CardSuit.C, CardValue.EIGHT),new Card(CardSuit.H, CardValue.NINE)
			);

	public static final List<Card> hand2 = List.of(
			new Card(CardSuit.C, CardValue.TWO), 
			new Card(CardSuit.C, CardValue.TWO), new Card(CardSuit.C, CardValue.FOUR), 
			new Card(CardSuit.C, CardValue.FIVE),new Card(CardSuit.C, CardValue.SIX)
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
		String result = evaluateHands.determineWinner();
		System.out.println(result);
		
		ArrayList<Integer> weights1 = new ArrayList<>(Arrays.asList(10,11,1,9,8));
		ArrayList<Integer> weights2 = new ArrayList<>(Arrays.asList(2,10,1,4,0));
		//String result = highCard(weights1, weights2);
//		List<List<Integer>> listsOfWeigh = getListsOfWeights(weights);
//		System.out.println(listsOfWeigh);
//		System.out.println(listsOfWeigh.size());
	}
}

