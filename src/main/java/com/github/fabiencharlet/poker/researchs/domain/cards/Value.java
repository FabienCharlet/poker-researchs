package com.github.fabiencharlet.poker.researchs.domain.cards;

public enum Value {
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13),
	ACE(14);

	final int intValue;

	private Value(final int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}
}
