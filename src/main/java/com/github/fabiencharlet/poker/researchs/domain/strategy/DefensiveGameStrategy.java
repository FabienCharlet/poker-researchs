package com.github.fabiencharlet.poker.researchs.domain.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.Choice;
import com.github.fabiencharlet.poker.researchs.domain.Game;
import com.github.fabiencharlet.poker.researchs.domain.Player;
import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.google.common.collect.Multimap;

public class DefensiveGameStrategy {


	public Choice makePreflopDecision(
			final Player player,
			final Collection<Card> hand,
			final int position,
			final Multimap<Player, Integer> betsByPlayer) {

		final List<Card> cards = new ArrayList<>(hand);

		final int handScore = HandEvaluator.preFlopChancesToWin(cards);
		int highestBet = betsByPlayer.values().stream().reduce(Integer::max).orElse(Game.BLIND_AMOUNT);

		// Check on big blind if nobody bet higher than big blind
		if (position == 4 && highestBet <= Game.BLIND_AMOUNT) {

			System.out.println(player.name + " => Big blind, CHECK" );
			return Choice.check();
		}

		// Check on small blind if nobody bet higher than big blind. Let's play with lower game
		if (position == 3 && highestBet <= Game.BLIND_AMOUNT && handScore >= 30) {

			System.out.println(player.name + " => small blind, CALL" );
			return Choice.call(Game.BLIND_AMOUNT / 2);
		}

		if (handScore >= 50) {

			System.out.println(player.name + " => hand score is good (" + handScore + ") => CALL" );
			return Choice.call(highestBet);
		}

		System.out.println(player.name + " => hand score is not enough (" + handScore + ") => FOLD" );
		return Choice.fold();
	}
}
