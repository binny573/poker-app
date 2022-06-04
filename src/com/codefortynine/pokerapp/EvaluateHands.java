package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvaluateHands {
	
	private List<Card> hand1;
	private List<Card> hand2;
	private List<CardValue> listOfPossibleCardValues = new ArrayList<>();
	
	private List<CardSuit> cs1 = new ArrayList<CardSuit>();
	private List<CardSuit> cs2 = new ArrayList<CardSuit>();
	private List<CardValue> cv1 = new ArrayList<CardValue>();
	private List<CardValue> cv2 = new ArrayList<CardValue>();
	
	/* Assigns weight to get winner based on high card*/
	private List<Integer> hand1weights = new ArrayList<>();
	private List<Integer> hand2weights = new ArrayList<>();
	
	private Boolean cs1FlushFlag = false;
	private Boolean cs2FlushFlag = false;
	
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
		createListOfPossibleValues(); 
		createListOfSuits();
		createListOfValues();
		createListOfHandWeights();
		setFlushFlag();
		System.out.println(hand1weights);
		System.out.println(hand2weights);	
//		String highCardOutput = highCard();
		String output = straightFlush();
		if(output == null) {
			output = fourOfAKind();
		}
		else if(output == null) {
			output = fullHouse();
		}
		else if(output == null) {
			output = fourOfAKind();
		}
		else if(output == null) {
			output = flush();
		}
		else if(output == null) {
			output = straight();
		}
		else if(output == null) {
			output = threeOfAKind();
		}
		else if(output == null) {
			output = twoPairs();
		}
		else if(output == null) {
			output = pair();
		}
		else if(output == null) {
			output = highCard();
		}
		else if(output == null) {
			output = "Some error in the cards";
		}
		
		
		//String result = straightFlush();
		//System.out.println(result); ---- print this and return from determine winner  
		
		System.out.println(listOfPossibleCardValues.indexOf(cv1.get(0)));
		
		if (cv1.get(1) == listOfPossibleCardValues.get(0)) System.out.println(true);
		else System.out.println(false);
//		System.out.println(listOfPossibleCardValues);
//		System.out.println(cs1FlushFlag);
//		System.out.println(cs2FlushFlag);
		//HashMap<CarSuit, int> frequncymap = getCountOfUnqiueSuits();
		
//		Long maxSuitCountcs1 = Collections.max(countOfcs1.values());
//		Long maxSuitCountcs2 = Collections.max(countOfcs2.values());
//		System.out.println("Card suit1 " + countOfcs1);
//		System.out.println("Card suit2 " + countOfcs2);

//		System.out.println(maxSuitCountcs1);
//		System.out.println(maxSuitCountcs2);
		
		Map<Object, Long> countOfcv1 =
				cv1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map<Object, Long> countOfcv2 =
				cv2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		//System.out.println("Card value1 "+ countOfcv1);
		//System.out.println("Card value2 "+ countOfcv2);
		return output;
	}
	
	private void createListOfHandWeights() {
		// TODO Auto-generated method stub
		for (CardValue cardSuit : cv1) {
//			System.out.println(listOfPossibleCardValues.indexOf(cardSuit));
			hand1weights.add(listOfPossibleCardValues.indexOf(cardSuit));
		}
		for (CardValue cardSuit : cv2) {
//			System.out.println(listOfPossibleCardValues.indexOf(cardSuit));
			hand2weights.add(listOfPossibleCardValues.indexOf(cardSuit));
		}
		
	}

	private void createListOfPossibleValues() {
		for (CardValue cardValue : CardValue.values()) { 
			listOfPossibleCardValues.add(cardValue);
		}
		
	}

	//public Hashmap
	
	public void setFlushFlag() {
		Map<Object, Long> countOfcs1 =
				cs1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map<Object, Long> countOfcs2 =
				cs2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		Long maxSuitCountcs1 = Collections.max(countOfcs1.values());
		Long maxSuitCountcs2 = Collections.max(countOfcs2.values());
		//System.out.println(countOfcs1);
		//System.out.println(countOfcs2);
		if(maxSuitCountcs1 == 5) cs1FlushFlag = true;
		if(maxSuitCountcs2 == 5) cs2FlushFlag = true;
	}
	
	public void setMaxValue() {
		
	}
	
	public void createListOfSuits() {
		for (int i = 0; i < this.numberOfHandCards; i++) 			
			cs1.add(this.hand1.get(i).getSuit());
		
		for (int i = 0; i < this.numberOfHandCards; i++) 
			cs2.add(this.hand2.get(i).getSuit());
	}
	public void createListOfValues() {
		for (int s = 0; s < this.numberOfHandCards; s++) {
			cv1.add(this.hand1.get(s).getValue());
		}
		for (int s = 0; s < this.numberOfHandCards; s++) {
			cv2.add(this.hand2.get(s).getValue());
		
		}
	}

	
	public String straightFlush() {
//		System.out.println(cs1FlushFlag);
//		System.out.println(cs2FlushFlag);
		if (cs1FlushFlag && cs2FlushFlag == false) 				return h1Win;
			
		else if (cs1FlushFlag == false && cs2FlushFlag) 		return h2Win;
		
		else if(cs1FlushFlag && cs2FlushFlag) {
			return highCard();
			//System.out.println("Card with highest value wins ie highest index in that map and then return a string");
		}
		else return null;
			
//		if()
//		System.out.println("Success with Straight Flush");
//		return true;
//		else 
//		System.out.println("Check for a lower category");
//		return false;
	}
	public String fourOfAKind() {

		return null;
	}
	public String fullHouse() {

		return null;
	}
	public String flush() {

		return null;
	}
	public String straight() {

		return null;
	}
	public String threeOfAKind() {

		return null;
	}
	public String twoPairs() {

		return null;
	}
	public String pair() {

		return null;
	}
	public String highCard() {
		System.out.println("High card was used");
		if (Collections.max(hand1weights)>Collections.max(hand2weights)) return h1Win;
		else if (Collections.max(hand2weights)>Collections.max(hand1weights)) return h2Win;
		else {
			return "wait";
		}
	}

}
