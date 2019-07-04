package com.github.fabiencharlet.poker.researchs.domain;

public class Card {

	public enum VALUE {

		TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);

		int intValue;

		private VALUE(final int intValue) {

			this.intValue = intValue;
		}
	}

	public enum COLOR {

		SPADE, HEART, DIAMOND, CLUB
	}

	public static Card of(final VALUE value, final COLOR color) {

		return new Card(value, color);
	}

	public final VALUE value;
	public final COLOR color;

	private Card(final VALUE value, final COLOR color) {

		this.value = value;
		this.color = color;
	}

	@Override
	public String toString() {

		String res;

		if (value.intValue == 14) {

			res = "A";

		} else if (value.intValue <= 10) {

			res = String.valueOf(value.intValue);

		} else {

			res = value.name().substring(0, 1);
		}

		return res + color.name().substring(0, 1).toLowerCase();
	}

}
