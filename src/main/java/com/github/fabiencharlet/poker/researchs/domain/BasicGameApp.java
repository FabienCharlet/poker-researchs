package com.github.fabiencharlet.poker.researchs.domain;

public class BasicGameApp {

	public static void main(final String[] args) {

		final Game game = Game.of(Deck.poker52Cards(),
										Player.of("Fabien", 500),
										Player.of("Christophe", 500),
										Player.of("Joel", 500),
										Player.of("Yuan", 500),
										Player.of("Marc", 500));

		game.turn();
	}
}
