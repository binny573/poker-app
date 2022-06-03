package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvaluateHands {
	
	private List<Card> hand1;
	private List<Card> hand2;
	private List<CardSuit> cs1 = new ArrayList<CardSuit>();
	private List<CardSuit> cs2 = new ArrayList<CardSuit>();
	private List<CardValue> cv1 = new ArrayList<CardValue>();
	private List<CardValue> cv2 = new ArrayList<CardValue>();
	
	private static final String h1Win = "Congratulations Hand1 has won !!";
	private static final String h2Win = "Congratulations Hand2 has won !!";
	
	private int numberOfHandCards;
	
	public EvaluateHands(List<Card> hand1, List<Card> hand2, int numberOfHandCards) {
		super();
		this.hand1 = hand1;
		this.hand2 = hand2;
		this.numberOfHandCards = numberOfHandCards;
	}
	
	/*
	This method prints whether hand1 won on hand2
	Methods return 
	 */
	public String determineWinner() {
		createListOfSuits();
		createListOfValues();
		//HashMap<CarSuit, int> frequncymap = getCountOfUnqiueSuits();
		
		Map<Object, Long> countOfcs1 =
				cs1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map<Object, Long> countOfcs2 =
				cs2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		System.out.println(countOfcs1);
		System.out.println(countOfcs2);
		//if(straightFlush()==true) 
		
		//System.out.println(n);
		//System.out.println(this.hand1);
		//System.out.println(this.hand2);
		return null;
	}
	
	//public Hashmap
	
	public void createListOfSuits() {
		for (int i = 0; i < numberOfHandCards; i++) 			
			cs1.add(hand1.get(i).getSuit());
		
		for (int i = 0; i < numberOfHandCards; i++) 
			cs2.add(hand2.get(i).getSuit());
	}
	public void createListOfValues() {
		for (int s = 0; s < numberOfHandCards; s++) {
			cv1.add(hand1.get(s).getValue());
		}
		for (int s = 0; s < numberOfHandCards; s++) {
			cv2.add(hand2.get(s).getValue());
		
		}
	}

	
	public Boolean straightFlush() {
//		if()
//		System.out.println("Success with Straight Flush");
//		return true;
//		else 
//		System.out.println("Check for a lower category");
//		return false;
		return true;
	}
	public Boolean fourOfAKind() {

		return true;
	}
	public Boolean fullHouse() {

		return true;
	}
	public Boolean flush() {

		return true;
	}
	public Boolean straight() {

		return true;
	}
	public Boolean threeOfAKind() {

		return true;
	}
	public Boolean twoPairs() {

		return true;
	}
	public Boolean pair() {

		return true;
	}
	public Boolean highCard() {

		return true;
	}

}
