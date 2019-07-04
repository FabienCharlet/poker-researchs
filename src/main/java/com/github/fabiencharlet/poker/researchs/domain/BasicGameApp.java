package com.github.fabiencharlet.poker.researchs.domain;

public class BasicGameApp {

	public static void main(final String[] args) {

		final Game game = Game.of(Deck.poker52Cards(),
										Player.of("Fabien"),
										Player.of("Christophe"),
										Player.of("Joel"),
										Player.of("Yuan"),
										Player.of("Marc"));

		game.turn();
	}
}
