package com.github.fabiencharlet.poker.researchs.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.github.fabiencharlet.poker.researchs.domain.strategy.DefensiveGameStrategy;
import com.github.fabiencharlet.poker.researchs.util.Cards;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Game {

	public enum PHASE {

		PRE_FLOP,
		FLOP,
		TURN,
		RIVER,
		SHOWDOWN
	}


	public static final int BLIND_AMOUNT = 10;

	private final Deck deck;
	private final int dealer = 0;
	private final Map<Player, Integer> moneyByPlayer = new HashMap<>();
	final Multimap<Player, Integer> betsByPlayer = HashMultimap.create();
	private final List<Player> players;
	private final List<Card> flop = new ArrayList<>();

	public static Game of(final Deck deck, final Player... players) {

		return new Game(deck, Arrays.asList(players));
	}

	private Game(final Deck deck, final List<Player> players) {

		this.deck = deck;
		this.players = players;

		for (final Player player : players) {

			moneyByPlayer.put(player, 500);
		}
	}

	public Game turn() {

		final PHASE phase = PHASE.PRE_FLOP;
		final DefensiveGameStrategy strategy = new DefensiveGameStrategy();

		final Deck turnDeck = deck.shuffle();
		final Multimap<Player, Card> hands = HashMultimap.create();

		final int nbPlayers = players.size();
		giveCards(turnDeck, hands, nbPlayers);

		final int smallBlind = dealer + 1;
		final int bigBlind = dealer + 2;

		bet(playerAt(smallBlind), BLIND_AMOUNT / 2);
		bet(playerAt(bigBlind), BLIND_AMOUNT);

		for (int i = bigBlind+1; i < bigBlind+nbPlayers; i++) {

			final Player player = playerAt(i);
			//Choice choice = strategy.makeDecision(player, hands.get(player), i, betsByPlayer);
		}

		System.out.println("Bets : " + betsByPlayer);

		for (final Player player : players) {

			System.out.println("Best combination " + Cards.findHighestCombination(new ArrayList<>(hands.get(player)), flop));
		}

		return new Game(turnDeck, players);
	}

	private void giveCards(final Deck turnDeck, final Multimap<Player, Card> hands, final int nbPlayers) {

		for (int i = dealer+1; i <= dealer + (nbPlayers *  2); i++) {

			hands.put(playerAt(i), turnDeck.next());
		}

		for (final Player player : players) {

			System.out.println("Hand for " + player.name + " => " + hands.get(player));
		}

		turnDeck.next();
		flop.add(turnDeck.next());
		flop.add(turnDeck.next());
		flop.add(turnDeck.next());

		turnDeck.next();
		flop.add(turnDeck.next());

		turnDeck.next();
		flop.add(turnDeck.next());

		System.out.println("Flop : " + flop);

	}

	private void bet(final Player player, final int amount) {

		if (amount + currentBet(player) <= moneyByPlayer.get(player)) {

			betsByPlayer.put(player, amount);
		}
	}

	private int currentBet(final Player player) {

		int res = 0;

		for (final Integer bet : betsByPlayer.get(player)) {

			res += bet;
		}

		return res;
	}

	private Player playerAt(final int index) {

		return players.get(index % players.size());
	}
}
