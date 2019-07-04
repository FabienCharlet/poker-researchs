package com.github.fabiencharlet.poker.researchs.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.domain.Card.COLOR;
import com.github.fabiencharlet.poker.researchs.domain.Card.VALUE;
import com.google.common.collect.ImmutableList;

public class Deck {

	public static Deck poker52Cards() {

		final List<Card> cards = new ArrayList<Card>();

		for (final COLOR color : Card.COLOR.values()) {

			for (final VALUE value : Card.VALUE.values()) {

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
