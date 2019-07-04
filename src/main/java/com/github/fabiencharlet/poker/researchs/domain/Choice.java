package com.github.fabiencharlet.poker.researchs.domain;

public class Choice {

	public enum ACTION {
		
		FOLD,
		CHECK,
		CALL,
		RAISE
	}
	
	public final ACTION action;
	public final int amount;
	
	public static Choice fold() {
		
		return new Choice(ACTION.FOLD, 0);
	}
	
	public static Choice check() {
		
		return new Choice(ACTION.CHECK, 0);
	}
	
	public static Choice call(int amount) {
		
		return new Choice(ACTION.CALL, amount);
	}
	
	public static Choice raise(int amount) {
		
		return new Choice(ACTION.RAISE, amount);
	}

	
	private Choice(ACTION action, int amount) {
		
		this.action = action;
		this.amount = amount;
	}
	
}
