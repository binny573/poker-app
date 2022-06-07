package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PokerHands {
	
	private static final String h1Win = "Congratulations Hand 1 has won !!";
	private static final String h2Win = "Congratulations Hand 2 has won !!";
	
	private static final String straightFlushWin = "It was a Straight Flush poker hand !!";
	private static final String fourOfAKindWin = "It was a Four of a Kind poker hand !!";
	private static final String fullHouseWin = "It was a Full House poker hand !!";
	private static final String flushWin = "It was a Flush poker hand !!";
	private static final String straightWin = "It was a Straight poker hand !!";
	private static final String threeOfAKindWin = "It was a Three of a Kind poker hand !!";
	private static final String twoPairsWin = "It was a Two Pairs poker hand !!";
	private static final String pairWin = "It was a Pair poker hand !!";
	private static final String highCardWin = "It was a high Card poker hand !!";
	
	
	public String straightFlush(
			Boolean cs1FlushFlag, Boolean cs2FlushFlag,
			List<Integer> hand1weights, List<Integer> hand2weights,
			List<List<Integer>> listsOfConsecutiveWeightsh1, List<List<Integer>> listsOfConsecutiveWeightsh2
			) 
	{
		if(listsOfConsecutiveWeightsh1.size()==1 && listsOfConsecutiveWeightsh2.size()==1) {
		if (cs1FlushFlag && cs2FlushFlag == false) 		{
			System.out.println(straightFlushWin);
			return h1Win;
		}
			
		else if (cs1FlushFlag == false && cs2FlushFlag) {
			System.out.println(straightFlushWin);
			return h2Win;
		}
		
		else if(cs1FlushFlag && cs2FlushFlag) {
			if(Collections.max(hand1weights)>Collections.max(hand2weights)) {
				System.out.println(straightFlushWin);
				return h1Win;
			}
			else {
				System.out.println(straightFlushWin);
				return h2Win;
			}//System.out.println("Card with highest value wins ie highest index in that map and then return a string");
		}
		}
		else if (listsOfConsecutiveWeightsh1.size()==1 && listsOfConsecutiveWeightsh2.size()!=1 && cs1FlushFlag){
			System.out.println(straightFlushWin);
			return h1Win;
		}
		else if (listsOfConsecutiveWeightsh2.size()==1 && listsOfConsecutiveWeightsh1.size()!=1 && cs2FlushFlag) {
			System.out.println(straightFlushWin);
			return h2Win;
		}
		return null;
			
//		if()
//		System.out.println("Success with Straight Flush");
//		return true;
//		else 
//		System.out.println("Check for a lower category");
//		return false;
	}
	public String fourOfAKind(List<Integer> hand1weights, List<Integer> hand2weights,
			Long maxValueCountcv1, Long maxValueCountcv2, Integer maxOccurredWeightcv1, 
			Integer maxOccurredWeightcv2) {
		//System.out.println(maxValueCountcv1);
		//System.out.println( maxValueCountcv2);
		if (maxValueCountcv1 == 4 && maxValueCountcv2 != 4) {
			System.out.println(fourOfAKindWin);
			return h1Win;
		}
		else if (maxValueCountcv1 != 4 && maxValueCountcv2 == 4) {
			System.out.println(fourOfAKindWin);
			return h2Win;
		}
		else if (maxValueCountcv1 == 4 && maxValueCountcv2 == 4) {
			System.out.println(fourOfAKindWin);
			if(maxOccurredWeightcv1>maxOccurredWeightcv2) return h1Win;
			else if(maxOccurredWeightcv2>maxOccurredWeightcv1) return h2Win;
		}
		
		return null;
	}
	public String fullHouse(Long maxValueCountcv1, Long maxValueCountcv2, Set<Object> hand1PairValues, Set<Object> hand2PairValues,
			Set<Object> hand1TripletValue, Set<Object> hand2TripletValue, List<CardValue> listOfPossibleCardValues) {
/*
 * Need to check if remaining two are pairs then only works
 * 
	 */	Object setToEnum1 = null;
		Object setToEnum2 = null;
		
		for (Iterator<Object> it = hand1TripletValue.iterator(); it.hasNext(); ) 
			setToEnum1 = it.next();
		
		for (Iterator<Object> it = hand2TripletValue.iterator(); it.hasNext(); ) 
			setToEnum2 = it.next();
		   
//		System.out.println(hand1TripletValue);
		int hand1TripletWeight = listOfPossibleCardValues.indexOf(setToEnum1);
//		System.out.println(hand1TripletWeight);
		
		System.out.println(hand2TripletValue);
		int hand2TripletWeight = listOfPossibleCardValues.indexOf(setToEnum2);
//		System.out.println(hand2TripletWeight);
		
//		System.out.println("jkahsbndkjsan");
//		System.out.println(maxValueCountcv1);
//		System.out.println(maxValueCountcv2);
//		System.out.println(hand1TripletWeight);
//		System.out.println(hand2TripletWeight);
//		System.out.println("zingaaa");
//		System.out.println(hand1PairValues);
//		System.out.println(hand2PairValues);
		if (maxValueCountcv1 == 3 && maxValueCountcv2 != 3 && !hand1PairValues.isEmpty()) {
			System.out.println(fullHouseWin);
			return h1Win;
		}
		else if (maxValueCountcv1 != 3 && maxValueCountcv2 == 3 && !hand2PairValues.isEmpty()) {
			System.out.println(fullHouseWin);
			return h2Win;
		}
		else if (maxValueCountcv1 == 3 && maxValueCountcv2 == 3) {
			if(!hand1PairValues.isEmpty() && hand2PairValues.isEmpty()) {
				System.out.println(fullHouseWin);
				return h1Win;
			}
			else if(!hand2PairValues.isEmpty() && hand1PairValues.isEmpty()) {
				System.out.println(fullHouseWin);
				return h2Win;
			}
			else if (!hand1PairValues.isEmpty() && !hand2PairValues.isEmpty())
				if(hand1TripletWeight>hand2TripletWeight) {
					System.out.println(fullHouseWin);
					return h1Win;
				}
				else if (hand2TripletWeight>hand1TripletWeight) {
					System.out.println(fullHouseWin);
					return h2Win;
				}	
		}
		return null;
	}
	
	public String flush(Boolean cs1FlushFlag, Boolean cs2FlushFlag,
			List<Integer> hand1weights, List<Integer> hand2weights)
	{
		if (cs1FlushFlag && cs2FlushFlag == false) 	{
			System.out.println(flushWin);
			return h1Win;
		}
		
		else if (cs1FlushFlag == false && cs2FlushFlag) {
			System.out.println(flushWin);
			return h2Win;
		}
		
		else if(cs1FlushFlag && cs2FlushFlag) {
			System.out.println(flushWin);
			return highCard(hand1weights, hand2weights);
			//System.out.println("Card with highest value wins ie highest index in that map and then return a string");
		}
		else return null;

	}
	public String straight( List<Integer> hand1weights, List<Integer> hand2weights,
			List<List<Integer>> listsOfConsecutiveWeightsh1, List<List<Integer>> listsOfConsecutiveWeightsh2
) {
		if(listsOfConsecutiveWeightsh1.size()==1 && listsOfConsecutiveWeightsh2.size()==1) {
			if(Collections.max(hand1weights)>Collections.max(hand2weights)) {
				System.out.println(straightWin);
				return h1Win;
			}
			else {
				System.out.println(straightWin);
				return h2Win;
			}
		}
		else if (listsOfConsecutiveWeightsh1.size()==1 && listsOfConsecutiveWeightsh2.size()!=1 ){
			System.out.println(straightWin);
			return h1Win;
		}
		else if (listsOfConsecutiveWeightsh2.size()==1 && listsOfConsecutiveWeightsh1.size()!=1) {
			System.out.println(straightWin);
			return h2Win;
		}	
		return null;
	}
	public String threeOfAKind(Long maxValueCountcv1, Long maxValueCountcv2,
			Integer maxOccurredWeightcv1, Integer maxOccurredWeightcv2) 
	{
		if (maxValueCountcv1 == 3 && maxValueCountcv2 != 3) {
			System.out.println(threeOfAKindWin);
			return h1Win;
		}
		else if (maxValueCountcv1 != 3 && maxValueCountcv2 == 3) {
			System.out.println(threeOfAKindWin);
			return h2Win;
		}
		else if (maxValueCountcv1 == 3 && maxValueCountcv2 == 3) {
			System.out.println(threeOfAKindWin);
			//System.out.println("Write logic to compare weights of those Card Values");
			if(maxOccurredWeightcv1>maxOccurredWeightcv2) return h1Win;
			else if(maxOccurredWeightcv2>maxOccurredWeightcv1) return h2Win;
		}
		return null;
	}

	public String twoPairs() {

		return null;
	}
	
	public String pair(Set<Object> hand1PairValues, Set<Object> hand2PairValues,
			Set<Object> hand1SolitaryValues,Set<Object> hand2SolitaryValues,
			List<CardValue> listOfPossibleCardValues) {
		if(!hand1PairValues.isEmpty() && hand2PairValues.isEmpty()) {
			System.out.println(pairWin);
			return h1Win;
		}
		else if(!hand2PairValues.isEmpty() && hand1PairValues.isEmpty()) {
			System.out.println(pairWin);
			return h2Win;
		}
		else if (!hand1PairValues.isEmpty() && !hand2PairValues.isEmpty()) {
			Object setToEnum1 = null;
			Object setToEnum2 = null;
			for (Iterator<Object> it = hand1PairValues.iterator(); it.hasNext(); ) 
				setToEnum1 = it.next();
			
			for (Iterator<Object> it = hand2PairValues.iterator(); it.hasNext(); ) 
				setToEnum2 = it.next();
			
			int hand1PairWeight = listOfPossibleCardValues.indexOf(setToEnum1);
			int hand2PairWeight = listOfPossibleCardValues.indexOf(setToEnum2);
			if(hand1PairWeight>hand2PairWeight) {
				System.out.println(pairWin);
				return h1Win;				
			}
			else if(hand2PairWeight>hand1PairWeight) {
				System.out.println(pairWin);
				return h2Win;
			}
			else if(hand1PairWeight==hand2PairWeight) {
				List<Integer> hand1RemainingWeights = new ArrayList<Integer>();
				List<Integer> hand2RemainingWeights = new ArrayList<Integer>();
				Object o1 = null;
				for (Iterator<Object> it = hand1SolitaryValues.iterator(); it.hasNext(); ) {
					o1 = it.next();
					Integer temp1 = listOfPossibleCardValues.indexOf(o1);
					hand1RemainingWeights.add(temp1);
				}
					
				
				for (Iterator<Object> it = hand2SolitaryValues.iterator(); it.hasNext(); ) {
					o1 = it.next();
					Integer temp2 = listOfPossibleCardValues.indexOf(o1);
					hand2RemainingWeights.add(temp2);	
				}
				System.out.println(hand1RemainingWeights);
				System.out.println(hand2RemainingWeights);
				
				//Get weights of remaining 3 cards then literally same as high Card
				for (int i = 2; i>=0; i--) {
					if(hand1RemainingWeights.get(i)>hand2RemainingWeights.get(i)) {
						System.out.println(pairWin);
						return h1Win;
					}
					else if(hand2RemainingWeights.get(i)>hand1RemainingWeights.get(i)) {
						System.out.println(pairWin);
						return h2Win;
					}
				}	
			}
		}
					
		return null;
	}
	
	public static String highCard(List<Integer> weights1, List<Integer> weights2) {
		for (int i = 4; i>=0; i--) {
			if(weights1.get(i)>weights2.get(i)) {
				System.out.println(highCardWin);
				return h1Win;
			}
			else if(weights2.get(i)>weights1.get(i)) {
				System.out.println(highCardWin);
				return h2Win;
			}
		}
		return "The game is a tie";
	}
}
