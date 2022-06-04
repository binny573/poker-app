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
		createListofPossibleValues(); 
		createListOfSuits();
		createListOfValues();
		setFlushFlag();
		String result = straightFlush();
		System.out.println(result);
		
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
		
//		System.out.println("Card value1 "+ countOfcv1);
//		System.out.println("Card value2 "+ countOfcv2);
		//if(straightFlush()==true) 
		
		//System.out.println(n);
		//System.out.println(this.hand1);
		//System.out.println(this.hand2);
		return null;
	}
	
	private void createListofPossibleValues() {
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
		System.out.println(maxSuitCountcs1);
		if(maxSuitCountcs1 == 5) cs1FlushFlag = true;
		if(maxSuitCountcs2 == 5) cs2FlushFlag = true;
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
		if (cs1FlushFlag && cs2FlushFlag == false) {
				return h1Win;
			}
		else if (cs1FlushFlag ==false && cs2FlushFlag ) {
			return h2Win;
		}
		
		
			
//		if()
//		System.out.println("Success with Straight Flush");
//		return true;
//		else 
//		System.out.println("Check for a lower category");
//		return false;
		return null;
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
