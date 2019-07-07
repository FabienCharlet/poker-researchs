package com.github.fabiencharlet.poker.researchs;

import com.github.fabiencharlet.poker.researchs.domain.cards.Value;
import com.github.fabiencharlet.poker.researchs.domain.cards.Card.Builder;

public abstract class TestsBase {

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
}
