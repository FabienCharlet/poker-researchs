package com.github.fabiencharlet.poker.researchs.domain.strategy;

import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.github.fabiencharlet.poker.researchs.util.Combinations;

public class HandEvaluator {

	public static int preFlopChancesToWin(final List<Card> hand) {

		int res = 0;
		final Card first = hand.get(0);
		final Card second = hand.get(1);

		if (Combinations.areSuited(first, second)) {

			res += 12;
		}

		if (Combinations.arePair(first, second)) {

			res += 55;
		}

		res += goodiness(first);
		res += goodiness(second);

		return res < 100 ? res : 99;
	}

	private static int goodiness(final Card card) {

		final int res;

		switch (card.value) {

			case ACE: res = 50;	break;
			case KING: res = 38; break;
			case QUEEN: res = 30; break;
			case JACK: res = 20; break;

			default: res = (int) (card.value.getIntValue() * 1.7d); break;
		}

		return res;
	}
}
