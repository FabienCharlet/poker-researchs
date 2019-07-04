package com.github.fabiencharlet.poker.researchs.domain;

public class Player {

	public final String name;

	public static Player of(final String name) {

		return new Player(name);
	}

	private Player(final String name) {

		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
