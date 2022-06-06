package com.codefortynine.pokerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHands {
	
	private static final String h1Win = "Congratulations Hand1 has won !!";
	private static final String h2Win = "Congratulations Hand2 has won !!";
	
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
		System.out.println(maxValueCountcv1);
		System.out.println( maxValueCountcv2);
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
	public String fullHouse(Long maxValueCountcv1, Long maxValueCountcv2) {
/*
 * Need to check if remaining two are pairs then only works
 */
		if (maxValueCountcv1 == 3 && maxValueCountcv2 != 3) {
			System.out.println(fullHouseWin);
			return h1Win;
		}
		else if (maxValueCountcv1 != 3 && maxValueCountcv2 == 3) {
			System.out.println(fullHouseWin);
			return h2Win;
		}
		else if (maxValueCountcv1 == 3 && maxValueCountcv2 == 3) {
			System.out.println(fullHouseWin);
			System.out.println("Write logic to compare weights of those Card Values");
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
	public String threeOfAKind() {

		return null;
	}
	public String twoPairs() {

		return null;
	}
	public String pair() {

		return null;
	}
	public static String highCard(List<Integer> weights1, List<Integer> weights2) {
		for (int i = 4; i>=0; i--) {
			if(weights1.get(i)>weights2.get(i)) {
				System.out.println(highCardWin);
				return "h1Wins";
			}
			else if(weights2.get(i)>weights1.get(i)) {
				System.out.println(highCardWin);
				return "h2Wins";
			}	
		}
		return "The game is a tie";
	}

	

}
