package com.github.fabiencharlet.poker.researchs.domain;

import java.util.Arrays;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.github.fabiencharlet.poker.researchs.domain.cards.Color;
import com.github.fabiencharlet.poker.researchs.domain.cards.Value;
import com.github.fabiencharlet.poker.researchs.domain.strategy.HandEvaluator;

public class PreFlopStatsTable {

	public static void main(final String[] args) {

		final List<Card> spades = Arrays.asList(
				Card.of(Value.ACE, Color.SPADE),
				Card.of(Value.KING, Color.SPADE),
				Card.of(Value.QUEEN, Color.SPADE),
				Card.of(Value.JACK, Color.SPADE),
				Card.of(Value.TEN, Color.SPADE),
				Card.of(Value.NINE, Color.SPADE),
				Card.of(Value.EIGHT, Color.SPADE),
				Card.of(Value.SEVEN, Color.SPADE),
				Card.of(Value.SIX, Color.SPADE),
				Card.of(Value.FIVE, Color.SPADE),
				Card.of(Value.FOUR, Color.SPADE),
				Card.of(Value.THREE, Color.SPADE),
				Card.of(Value.TWO, Color.SPADE)
			);


		final List<Card> hearts = Arrays.asList(
				Card.of(Value.ACE, Color.HEART),
				Card.of(Value.KING, Color.HEART),
				Card.of(Value.QUEEN, Color.HEART),
				Card.of(Value.JACK, Color.HEART),
				Card.of(Value.TEN, Color.HEART),
				Card.of(Value.NINE, Color.HEART),
				Card.of(Value.EIGHT, Color.HEART),
				Card.of(Value.SEVEN, Color.HEART),
				Card.of(Value.SIX, Color.HEART),
				Card.of(Value.FIVE, Color.HEART),
				Card.of(Value.FOUR, Color.HEART),
				Card.of(Value.THREE, Color.HEART),
				Card.of(Value.TWO, Color.HEART)
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
