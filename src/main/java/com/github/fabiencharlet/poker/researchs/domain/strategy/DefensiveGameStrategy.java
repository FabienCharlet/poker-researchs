package com.github.fabiencharlet.poker.researchs.domain.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.Choice;
import com.github.fabiencharlet.poker.researchs.domain.Player;
import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.google.common.collect.Multimap;

public class DefensiveGameStrategy {


	public Choice makePreflopDecision(
			final Player player,
			final Collection<Card> hand,
			final int position,
			final int nbPlayers,
			final Multimap<Player, Integer> betsByPlayer) {

		final List<Card> cards = new ArrayList<>(hand);

		final int handScore = HandEvaluator.preFlopChancesToWin(cards, nbPlayers);


		// Check en grosse blinde
		if (position == 2) {

			return Choice.check();
		}

			//evaluateCards(hand);


		return null;
	}
}
