package com.github.fabiencharlet.poker.researchs.domain;

import java.util.Arrays;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.Card.COLOR;
import com.github.fabiencharlet.poker.researchs.domain.Card.VALUE;
import com.github.fabiencharlet.poker.researchs.domain.strategy.HandEvaluator;

public class PreFlopStatsTable {

	public static void main(String[] args) {
		
		List<Card> spades = Arrays.asList(
				Card.of(VALUE.ACE, COLOR.SPADE),
				Card.of(VALUE.KING, COLOR.SPADE),
				Card.of(VALUE.QUEEN, COLOR.SPADE),
				Card.of(VALUE.JACK, COLOR.SPADE),
				Card.of(VALUE.TEN, COLOR.SPADE),
				Card.of(VALUE.NINE, COLOR.SPADE),
				Card.of(VALUE.EIGHT, COLOR.SPADE),
				Card.of(VALUE.SEVEN, COLOR.SPADE),
				Card.of(VALUE.SIX, COLOR.SPADE),
				Card.of(VALUE.FIVE, COLOR.SPADE),
				Card.of(VALUE.FOUR, COLOR.SPADE),
				Card.of(VALUE.THREE, COLOR.SPADE),
				Card.of(VALUE.TWO, COLOR.SPADE)
			);
		
		
		List<Card> hearts = Arrays.asList(
				Card.of(VALUE.ACE, COLOR.HEART),
				Card.of(VALUE.KING, COLOR.HEART),
				Card.of(VALUE.QUEEN, COLOR.HEART),
				Card.of(VALUE.JACK, COLOR.HEART),
				Card.of(VALUE.TEN, COLOR.HEART),
				Card.of(VALUE.NINE, COLOR.HEART),
				Card.of(VALUE.EIGHT, COLOR.HEART),
				Card.of(VALUE.SEVEN, COLOR.HEART),
				Card.of(VALUE.SIX, COLOR.HEART),
				Card.of(VALUE.FIVE, COLOR.HEART),
				Card.of(VALUE.FOUR, COLOR.HEART),
				Card.of(VALUE.THREE, COLOR.HEART),
				Card.of(VALUE.TWO, COLOR.HEART)
			);
		
		for (int i = 0; i < 13; i++) {
			
			for (int j = 0; j < 13; j++) {
				
				int proba = 0;
				
				if (j > i) {
					
					proba = HandEvaluator.preFlopChancesToWin(Arrays.asList(spades.get(i), spades.get(j)), 5);
				} 
				else {
					

					proba = HandEvaluator.preFlopChancesToWin(Arrays.asList(spades.get(i), hearts.get(j)), 5);
				}
				
				if (proba < 10) {

					System.out.print("0");
				}
				System.out.print(proba);
				System.out.print(" ");
			}

			System.out.println();
		}
	}
}
