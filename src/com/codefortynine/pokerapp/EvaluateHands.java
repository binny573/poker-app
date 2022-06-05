package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		System.out.println(listOfPossibleCardValues);
		System.out.println(listOfPossibleCardValues.indexOf(CardValue.FIVE));
		Map<Object, CountWeight> keyCountWeightMapcv1 = getKeyCountWeighteMap(cv1);
		Map<Object, CountWeight> keyCountWeightMapcv2 = getKeyCountWeighteMap(cv2);
		System.out.println("Count " + keyCountWeightMapcv2.get(CardValue.TWO).getCount());
		System.out.println("Weight " + keyCountWeightMapcv2.get(CardValue.TWO).getWeight());

//		createListOfHandWeights();
//		setFlushFlag();
//		Long maxValueCountcv1 = countMaxValueCount(cv1);
//		Long maxValueCountcv2 = countMaxValueCount(cv2);
////		System.out.println(hand1weights);
////		System.out.println(hand2weights);	
////		String highCardOutput = highCard();
//		PokerHands pokerhands = new PokerHands();
//		String output = pokerhands.straightFlush(cs1FlushFlag, cs2FlushFlag, hand1weights, hand2weights);
//		if(output == null) {
//			System.out.println("here");
//			output = pokerhands.fourOfAKind(maxValueCountcv1, maxValueCountcv2);
//		}
//		if(output == null) {
//			System.out.println("ajkshbdj");
//			output = pokerhands.fullHouse(maxValueCountcv1, maxValueCountcv2);
//		}
//		if(output == null) {
//			output = pokerhands.flush(cs1FlushFlag, cs2FlushFlag, hand1weights, hand2weights);
//		}
//		if(output == null) {
//			output = pokerhands.straight();
//		}
//		if(output == null) {
//			output = pokerhands.threeOfAKind();
//		}
//		if(output == null) {
//			output = pokerhands.twoPairs();
//		}
//		if(output == null) {
//			output = pokerhands.pair();
//		}
//		if(output == null) {
//			output = pokerhands.highCard(hand1weights, hand2weights);
//		}
//		if(output == null) {
//			output = "Some error in the cards";
//		}
//		
//		
//		//String result = straightFlush();
//		//System.out.println(result); ---- print this and return from determine winner  
//		
////		System.out.println(listOfPossibleCardValues.indexOf(cv1.get(0)));
////		
////		if (cv1.get(1) == listOfPossibleCardValues.get(0)) System.out.println(true);
////		else System.out.println(false);
////		System.out.println(listOfPossibleCardValues);
////		System.out.println(cs1FlushFlag);
////		System.out.println(cs2FlushFlag);
//		//HashMap<CarSuit, int> frequncymap = getCountOfUnqiueSuits();
//		
////		Long maxSuitCountcs1 = Collections.max(countOfcs1.values());
////		Long maxSuitCountcs2 = Collections.max(countOfcs2.values());
////		System.out.println("Card suit1 " + countOfcs1);
////		System.out.println("Card suit2 " + countOfcs2);
//
////		System.out.println(maxSuitCountcs1);
////		System.out.println(maxSuitCountcs2);
//		
//		Map<Object, Long> countOfcv1 =
//				cv1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//		Map<Object, Long> countOfcv2 =
//				cv2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//		
//		System.out.println("Card value1 "+ countOfcv1);
//		System.out.println("Card value2 "+ countOfcv2);
		return null;
//		return output;
	}
	
	private Map<Object, CountWeight> getKeyCountWeighteMap(List<CardValue> cv) {
		Map<Object, Long> countOfCv =
				cv.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(countOfCv);

		Map<Object, CountWeight> keyCountValueMap = new HashMap<Object, CountWeight>();
		for (int i = 1; i<=4; i++) {
			for(Entry<Object, Long> entry: countOfCv.entrySet()) {
				CountWeight countWeight = new CountWeight();
				if(entry.getValue() == i) {
			        System.out.println("The key for value " + i + " is " + entry.getKey());
			        Long count = entry.getValue();
			        int weight = listOfPossibleCardValues.indexOf(entry.getKey());
			        System.out.println(weight);
			        countWeight.setCount(count);
			        countWeight.setWeight(weight);
			        keyCountValueMap.put(entry.getKey(), countWeight);
			        //Something like K,4, 11....ie K occurs 4 times and has weight 12
			      }

			}		
		}
		return keyCountValueMap;
	}
		

	private Long countMaxValueCount(List<CardValue> cv) {
		Map<Object, Long> countOfCv =
				cv.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		Long maxValueCount = Collections.max(countOfCv.values());
		// 5 is not possible because only eg. 4 Aces exist in a deck
		if (maxValueCount == 4)
		{
			for(Entry<Object, Long> entry: countOfCv.entrySet()) {
			      if(entry.getValue() == maxValueCount) {
			        System.out.println("The key for value " + maxValueCount + " is " + entry.getKey());
			      }
			}
			
		}
		else if (maxValueCount == 3)
		{
		//Add code to create a Map that will add key to that weight		
		}
		else if (maxValueCount == 2)
		{
			
		}
		else if (maxValueCount == 1) {
				//Guess also not needed
			}
		for (Map.Entry<Object, Long> entry : countOfCv.entrySet()) {
//				    System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
			}
		//return the weight which is repeated maximum times
		return maxValueCount;
	}

	private void createListOfHandWeights() {
		// TODO Auto-generated method stub
		for (CardValue cardValue : cv1) {
//			System.out.println(listOfPossibleCardValues.indexOf(cardSuit));
			hand1weights.add(listOfPossibleCardValues.indexOf(cardValue));
		}
		for (CardValue cardValue : cv2) {
//			System.out.println(listOfPossibleCardValues.indexOf(cardSuit));
			hand2weights.add(listOfPossibleCardValues.indexOf(cardValue));
		}
	}

	private void createListOfPossibleValues() {
		for (CardValue cardValue : CardValue.values()) { 
			listOfPossibleCardValues.add(cardValue);
		}
		
	}

	//public Hashmap
	//not redundant cz we deal in CardSuits here and not CardValue
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
		for (int s = 0; s < this.numberOfHandCards; s++) 	cv1.add(this.hand1.get(s).getValue());
		for (int s = 0; s < this.numberOfHandCards; s++)	cv2.add(this.hand2.get(s).getValue());
		//System.out.println(cv1);
	}


}
