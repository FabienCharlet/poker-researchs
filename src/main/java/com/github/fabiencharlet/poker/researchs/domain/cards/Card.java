package com.github.fabiencharlet.poker.researchs.domain.cards;

public class Card {

	public static class Builder {

		private final Value value;

		public Builder(final Value value) {
			this.value = value;
		}

		public Card ofSpade() { return Card.of(value, Color.SPADE); }
		public Card ofHeart() { return Card.of(value, Color.HEART); }
		public Card ofDiamond() { return Card.of(value, Color.DIAMOND); }
		public Card ofClub() { return Card.of(value, Color.CLUB); }
	}

	public static Builder two() { return new Builder(Value.TWO); }
	public static Builder three() { return new Builder(Value.THREE); }
	public static Builder four() { return new Builder(Value.FOUR); }
	public static Builder five() { return new Builder(Value.FIVE); }
	public static Builder six() { return new Builder(Value.SIX); }
	public static Builder seven() { return new Builder(Value.SEVEN); }
	public static Builder eight() { return new Builder(Value.EIGHT); }
	public static Builder nine() { return new Builder(Value.NINE); }
	public static Builder ten() { return new Builder(Value.TEN); }
	public static Builder jack() { return new Builder(Value.JACK); }
	public static Builder queen() { return new Builder(Value.QUEEN); }
	public static Builder king() { return new Builder(Value.KING); }
	public static Builder ace() { return new Builder(Value.ACE); }

	public static Card of(final Value value, final Color color) {

		return new Card(value, color);
	}

	public final Value value;
	public final Color color;

	private Card(final Value value, final Color color) {

		this.value = value;
		this.color = color;
	}

	public Value getValue() {
		return value;
	}
	public Color getColor() {
		return color;
	}
	@Override
	public String toString() {

		return value.toString() + color.name().substring(0, 1).toLowerCase();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Card other = (Card) obj;
		if (color != other.color) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}
}


