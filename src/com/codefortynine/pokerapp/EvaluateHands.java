package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
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
	private List<Integer> hand1Weights = new ArrayList<>();
	private List<Integer> hand2Weights = new ArrayList<>();
	
	private Boolean cs1FlushFlag = false;
	private Boolean cs2FlushFlag = false;
	
	private int numberOfHandCards;
	
	private static final String tie = "It is a tie!!" ;
	private static final String invalidCards = "Please check if the cards you entered can coexist in a single deck...This gives no result!!" ;

	
	public EvaluateHands(List<Card> hand1, List<Card> hand2, int numberOfHandCards) {
		super();
		this.hand1 = hand1;
		this.hand2 = hand2;
		this.numberOfHandCards = numberOfHandCards;
		
		System.out.println("...Welcome to the Poker App!!...\n   Let us check which hand won\n.................................");
		createListOfPossibleValues();
		createListOfSuits();
		createListOfValues();
/*
 * Might be an unused map
 */
		Map<Object, CountWeight> keyCountWeightMapcv1 = getKeyCountWeighteMap(cv1);
		Map<Object, CountWeight> keyCountWeightMapcv2 = getKeyCountWeighteMap(cv2);
		createListOfHandWeights();
		setFlushFlag();
	}
	/*
	This method prints whether hand1 won on hand2
	Methods return 
	 */
	public static Set<Object> getValuesFornOccurrences(Map<Object, Long> map, Long value) {
	    Set<Object> keys = new HashSet<Object>();
	    for (Entry<Object, Long> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	public String determineWinner() {

		Map<Object, Long> cardValueCount1 = getCardValueCount(cv1);
		Map<Object, Long> cardValueCount2 = getCardValueCount(cv2);
		
		Set<Object> hand1PairValues = (Set<Object>) getValuesFornOccurrences(cardValueCount1, Long.valueOf(2));
		Set<Object> hand2PairValues = (Set<Object>) getValuesFornOccurrences(cardValueCount2, Long.valueOf(2));
		
		Set<Object> hand1TripletValue = (Set<Object>) getValuesFornOccurrences(cardValueCount1, Long.valueOf(3));
		Set<Object> hand2TripletValue = (Set<Object>) getValuesFornOccurrences(cardValueCount2, Long.valueOf(3));
		
		Set<Object> hand1SolitaryValues = (Set<Object>) getValuesFornOccurrences(cardValueCount1, Long.valueOf(1));
		Set<Object> hand2SolitaryValues = (Set<Object>) getValuesFornOccurrences(cardValueCount2, Long.valueOf(1));
				
		Long maxValueCountcv1 = getMaxValueCount(cardValueCount1);
		Long maxValueCountcv2 = getMaxValueCount(cardValueCount2);
		
		PokerHands pokerhands = new PokerHands();
		List<List<Integer>> listsOfConsecutiveWeightsh1 =  getListsOfConsecutiveWeights(hand1Weights);
		List<List<Integer>> listsOfConsecutiveWeightsh2 =  getListsOfConsecutiveWeights(hand2Weights);
		Integer maxOccurredWeightcv1 = getMaxOccurredWeight(hand1Weights);
		Integer maxOccurredWeightcv2 = getMaxOccurredWeight(hand2Weights);
				
//		System.out.println(hand1Weights);
//		System.out.println(hand2Weights);
		if(hand1Weights.equals(hand2Weights)) return tie;
		
		String decision = pokerhands.straightFlush(cs1FlushFlag, cs2FlushFlag, hand1Weights, hand2Weights,
				listsOfConsecutiveWeightsh1, listsOfConsecutiveWeightsh2);
		if(decision == null) {
			decision = pokerhands.fourOfAKind(hand1Weights, hand2Weights,
					maxValueCountcv1, maxValueCountcv2, maxOccurredWeightcv1, maxOccurredWeightcv2);
		}
		if(decision == null) {
			decision = pokerhands.fullHouse(maxValueCountcv1, maxValueCountcv2, hand1PairValues, hand2PairValues,
					hand1TripletValue, hand2TripletValue, listOfPossibleCardValues);
		}
		if(decision == null) {
			decision = pokerhands.flush(cs1FlushFlag, cs2FlushFlag, hand1Weights, hand2Weights);
		}
		if(decision == null) {
			decision = pokerhands.straight(hand1Weights, hand2Weights, listsOfConsecutiveWeightsh1, listsOfConsecutiveWeightsh2);
		}
		if(decision == null) {
			decision = pokerhands.threeOfAKind(maxValueCountcv1, maxValueCountcv2, maxOccurredWeightcv1, maxOccurredWeightcv2);
		}
		if(decision == null) {
			decision = pokerhands.twoPairs(hand1PairValues, hand2PairValues,hand1SolitaryValues,hand2SolitaryValues, listOfPossibleCardValues);
		}
		if(decision == null) {
			decision = pokerhands.pair(hand1PairValues, hand2PairValues, hand1SolitaryValues, hand2SolitaryValues, listOfPossibleCardValues);
		}
		if(decision == null) {
			decision = PokerHands.highCard(hand1Weights, hand2Weights);
		}
		if(decision == null) {
			decision = invalidCards;
		}

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
		return decision;
	}
/*
 * Gives List of Lists of consecutive CardValues, expressed as weights
 */
	public static int getMaxOccurredWeight(List<Integer> arr){
	    int tempcount = 0;
	    int temp = 0;
		int maxOccured = arr.get(0);
	    int count = 1;

	    for(int i = 0; i < arr.size(); i++) {
	        temp = arr.get(i);
	        tempcount = 0;
	        for(int j = 1; j < arr.size(); j++) {
	            if(temp == arr.get(j))
	                tempcount++;
	        }
	        if (tempcount > count) {
	        	maxOccured = temp;
	            count = tempcount;
	        }
	    }
	    return maxOccured;
	}
	
	public static List<List<Integer>> getListsOfConsecutiveWeights(List<Integer> weights) {
		List<List<Integer>> listsOfWeights = new ArrayList<>();
		int lowerIndex = 0;
		int upperIndex = 1;
		for (int i = 0; i<5;i++) {
			if(i!=4 && (weights.get(i+1) - weights.get(i) == 1)) 
				upperIndex++;
			else {
				listsOfWeights.add(weights.subList(lowerIndex, upperIndex));
				lowerIndex = i+1;
				upperIndex = i +2;
			}
		}
//		System.out.println(listsOfWeights);
		return listsOfWeights;
	}
	
/*
 * getKeyCountWeighteMap() unused in the main program flow, formulated to simplify tasks in the initial stages.
 * But better alternatives found so dropped.
 */
	private Map<Object, CountWeight> getKeyCountWeighteMap(List<CardValue> cv) {
		Map<Object, Long> countOfCv =
				cv.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		Map<Object, CountWeight> keyCountValueMap = new HashMap<Object, CountWeight>();
		for (int i = 1; i<=4; i++) {
			for(Entry<Object, Long> entry: countOfCv.entrySet()) {
				CountWeight countWeight = new CountWeight();
				if(entry.getValue() == i) {
			        //System.out.println("The key for value " + i + " is " + entry.getKey());
			        Long count = entry.getValue();
			        int weight = listOfPossibleCardValues.indexOf(entry.getKey());
			        countWeight.setCount(count);
			        countWeight.setWeight(weight);
			        keyCountValueMap.put(entry.getKey(), countWeight);
			        //Something like K,4, 11....ie K occurs 4 times and has weight 12
			      }
			}		
		}
		return keyCountValueMap;
	}
	
	private Map<Object, Long> getCardValueCount(List<CardValue> cv){
		Map<Object, Long> countOfCv =
				cv.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println("Card Values and their count respectively \n\t"+countOfCv);
		return countOfCv;
	}
		
	private Long getMaxValueCount(Map<Object, Long> cardValueCount) {
		Long maxValueCount = Collections.max(cardValueCount.values());
		return maxValueCount;
	}

	private void createListOfHandWeights() {
		for (CardValue cardValue : cv1) {
			hand1Weights.add(listOfPossibleCardValues.indexOf(cardValue));
			Collections.sort(hand1Weights);
		}
		for (CardValue cardValue : cv2) {
			hand2Weights.add(listOfPossibleCardValues.indexOf(cardValue));
			Collections.sort(hand2Weights);
		}
	}

	private void createListOfPossibleValues() {
		for (CardValue cardValue : CardValue.values()) { 
			listOfPossibleCardValues.add(cardValue);
		}
	}

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
	}


}
