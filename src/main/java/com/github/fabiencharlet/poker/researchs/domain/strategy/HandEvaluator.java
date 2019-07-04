package com.github.fabiencharlet.poker.researchs.domain.strategy;

import java.util.Collection;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.Card;
import com.github.fabiencharlet.poker.researchs.domain.Card.COLOR;
import com.github.fabiencharlet.poker.researchs.domain.Card.VALUE;

public class HandEvaluator {

	public static int preFlopChancesToWin(List<Card> hand, int nbPlayers) {
		
		int res = 0;
		Card first = hand.get(0);
		Card second = hand.get(1);
		
		if (areSuited(first, second)) {
			
			res += 12;
		}
		
		if (arePair(first, second)) {
			
			res += 55;
		}
		
		res += goodiness(first);
		res += goodiness(second);
		
		return res < 100 ? res : 99;
	}
	
	private static boolean arePair(Card first, Card second) {

		return first.value == second.value;
	}
	
	private static int goodiness(Card card) {
		
		final int res;
		
		switch (card.value) {
		
			case ACE: res = 45;	break;
			case KING: res = 30; break;
			case QUEEN: res = 25; break;
			case JACK: res = 20; break;
			
			default: res = (int) (card.value.getIntValue() * 1.5d); break;
		}
		
		return res;
	}

	public static boolean areSuited(Card... cards) {
		
		for (int i = 1; i < cards.length; i++) {
			
			if (cards[i].color != cards[0].color) {
				
				return false;
			}
		}
		
		return true;
	}
	
}
