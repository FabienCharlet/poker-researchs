package com.github.fabiencharlet.poker.researchs.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.fabiencharlet.poker.researchs.domain.Player;
import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.github.fabiencharlet.poker.researchs.domain.cards.Result;
import com.github.fabiencharlet.poker.researchs.util.Combinations.Combination;
import com.google.common.collect.Multimap;

public class WinnersFinder {

	public static List<Player> findWinners(List<Player> notFoldedPlayers, Multimap<Player, Card> hands, List<Card> flop) {

		Map<Result, Player> bestCombinationsByPlayer = new HashMap<>();

		for (final Player player : notFoldedPlayers) {

			Result bestCombination = Combinations.findHighestCombination(new ArrayList<>(hands.get(player)), flop);
			System.out.println(player + " => Best combination " + bestCombination);
			bestCombinationsByPlayer.put(bestCombination, player);
		}

		Combination bestCombination = bestCombinationsByPlayer.keySet().stream()
			.map(Result::getCombination)
			.distinct()
			.sorted(Comparator.reverseOrder())
			.findFirst().get();

		List<Player> playersWithBestCombination = bestCombinationsByPlayer.entrySet().stream()
				.filter(e -> e.getKey().combination == bestCombination)
				.map(e -> e.getValue()).collect(Collectors.toList());

		if (playersWithBestCombination.size() > 1) {

			return splitTied(playersWithBestCombination, bestCombinationsByPlayer);
		}

		return playersWithBestCombination;
	}

	public static List<Player> splitTied(List<Player> playersWithBestCombination,
			Map<Result, Player> bestCombinationsByPlayer) {

		b

		return null;
	}
}
