package com.github.fabiencharlet.poker.researchs.domain;

public class Player {

	public final String name;
	private final int money;

	public static Player of(final String name, final int money) {

		return new Player(name, money);
	}

	private Player(final String name, final int money) {

		this.name = name;
		this.money = money;
	}
}
