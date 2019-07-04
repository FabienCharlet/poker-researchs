package com.github.fabiencharlet.poker.researchs.domain;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Game {

	private final Deck deck;
	private final int dealer = 0;
	private final List<Player> players;

	public static Game of(final Deck deck, final Player... players) {

		return new Game(deck, Arrays.asList(players));
	}

	private Game(final Deck deck, final List<Player> players) {

		this.deck = deck;
		this.players = players;
	}

	public Game turn() {

		final Deck turnDeck = deck.shuffle();
		final Multimap<Player, Card> hands = HashMultimap.create();

		for (int i = dealer+1; i <= dealer + (players.size() *  2); i++) {

			final int playerIndex = i % players.size();
			hands.put(players.get(playerIndex), turnDeck.next());
		}

		for (final Player player : players) {

			System.out.println("Hand for " + player.name + " => " + hands.get(player));
		}

		return new Game(turnDeck, players);
	}


}
