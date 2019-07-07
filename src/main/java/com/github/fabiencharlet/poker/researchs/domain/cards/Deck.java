package com.github.fabiencharlet.poker.researchs.domain.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Deck {

	public static Deck poker52Cards() {

		final List<Card> cards = new ArrayList<Card>();

		for (final Color color : Color.values()) {

			for (final Value value : Value.values()) {

				cards.add(Card.of(value, color));
			}
		}

		return new Deck(cards);
	}

	private final List<Card> cards;
	private int currentCard = 0;

	private Deck(final List<Card> cards) {

		this.cards = ImmutableList.copyOf(cards);
	}

	public Card next() {

		return cards.get(currentCard++);
	}

	public Deck shuffle() {

		final List<Card> newCards = new ArrayList<Card>(cards);

		Collections.shuffle(newCards);

		return new Deck(newCards);
	}
}
