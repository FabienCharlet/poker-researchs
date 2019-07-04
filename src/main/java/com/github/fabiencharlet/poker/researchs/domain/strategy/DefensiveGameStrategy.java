package com.github.fabiencharlet.poker.researchs.domain.strategy;

import java.util.Collection;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.Card;
import com.github.fabiencharlet.poker.researchs.domain.Choice;
import com.github.fabiencharlet.poker.researchs.domain.Game.PHASE;
import com.github.fabiencharlet.poker.researchs.domain.Player;
import com.google.common.collect.Multimap;

public class DefensiveGameStrategy {
	

	public Choice makeDecision(
			Player player, 
			Collection<Card> hand,
			PHASE phase,
			int position, 
			int nbPlayers, 
			Multimap<Player, Integer> betsByPlayer) {
		
		if (phase == PHASE.PRE_FLOP) {
			
			// Check en grosse blinde
			if (position == 2) {
				
				return Choice.check();
			}
			
			//evaluateCards(hand);
			
		}
		return null;
	}
}
