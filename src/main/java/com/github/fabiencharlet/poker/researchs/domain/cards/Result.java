package com.github.fabiencharlet.poker.researchs.domain.cards;

import java.util.Arrays;
import java.util.List;

import com.github.fabiencharlet.poker.researchs.util.Combinations.Combination;

public class Result {

	public static Result highCard(final Card card) {

		return Result.of(Combination.HIGH_CARD, Arrays.asList(card));
	}

	public static Result onePair(final Card cardOne, final Card cardTwo) {

		if (cardOne.value != cardTwo.value) {
			throw new IllegalArgumentException("Cards of Pair shall have same value");
		}

		if (cardOne.value != cardTwo.value) {
			throw new IllegalArgumentException("Cards of Pair shall be different");
		}

		return Result.of(Combination.ONE_PAIR, Arrays.asList(cardOne, cardTwo));
	}

	public static Result twoPairs(final Card firstPairOne, final Card firstPairTwo, final Card secondPairOne, final Card secondPairTwo) {

		if (firstPairOne.value != firstPairTwo.value || secondPairOne.value != secondPairTwo.value) {
			throw new IllegalArgumentException("Cards of Pair shall have same value");
		}

		if (firstPairOne.value != firstPairTwo.value || secondPairOne.value != secondPairTwo.value) {
			throw new IllegalArgumentException("Cards of Pair shall be different");
		}

		return Result.of(Combination.TWO_PAIRS, Arrays.asList(firstPairOne, firstPairTwo, secondPairOne, secondPairTwo));
	}

	public static Result threeOfAKind(final Card cardOne, final Card cardTwo, final Card cardThree) {

		if (cardOne.value != cardTwo.value || cardOne.value != cardThree.value ) {
			throw new IllegalArgumentException("Cards of Pair shall have same value");
		}

		if (cardOne.value != cardTwo.value || cardOne.value != cardThree.value) {
			throw new IllegalArgumentException("Cards of Pair shall be different");
		}

		return Result.of(Combination.THREE_OF_A_KIND, Arrays.asList(cardOne, cardTwo, cardThree));
	}

	public static Object fourOfAKind(final Card cardOne, final Card cardTwo, final Card cardThree, final Card cardFour) {

		if (cardOne.value != cardTwo.value || cardOne.value != cardThree.value  || cardOne.value != cardFour.value) {
			throw new IllegalArgumentException("Cards of Four of a kind shall have same value");
		}

		if (cardOne.value != cardTwo.value || cardTwo.value != cardThree.value || cardThree.value != cardFour.value) {
			throw new IllegalArgumentException("Cards of Four of a kind shall be different");
		}

		return Result.of(Combination.FOUR_OF_A_KIND, Arrays.asList(cardOne, cardTwo, cardThree, cardFour));
	}


	public static Result fullHouse(final Card threeOne, final Card threeTwo, final Card threeThree, final Card pairOne, final Card pairTwo) {

		return Result.of(Combination.FULL_HOUSE, Arrays.asList(threeOne, threeTwo, threeThree, pairOne, pairTwo));
	}

	public static Result flush(final Card flushOne, final Card flushTwo, final Card flushThree, final Card flushFour, final Card flushFive) {

		if (flushOne.color != flushTwo.color || flushOne.color != flushThree.color || flushOne.color != flushFour.color || flushOne.color != flushFive.color) {
			throw new IllegalArgumentException("Cards of Flush shall have same color");
		}

		return Result.of(Combination.FLUSH, Arrays.asList(flushOne, flushTwo, flushThree, flushFour, flushFive));
	}

	public static Result straight(final Card straightOne, final Card straightTwo, final Card straightThree, final Card straightFour, final Card straightFive) {

		return Result.of(Combination.STRAIGHT, Arrays.asList(straightOne, straightTwo, straightThree, straightFour, straightFive));
	}

	public static Result straightFlush(final Card straightOne, final Card straightTwo, final Card straightThree, final Card straightFour, final Card straightFive) {

		return Result.of(Combination.STRAIGHT_FLUSH, Arrays.asList(straightOne, straightTwo, straightThree, straightFour, straightFive));
	}

	public static Result royalFlush(final Card straightOne, final Card straightTwo, final Card straightThree, final Card straightFour, final Card straightFive) {

		return Result.of(Combination.ROYAL_FLUSH, Arrays.asList(straightOne, straightTwo, straightThree, straightFour, straightFive));
	}

	public final Combination combination;
	public final List<Card> cards;

	public static  Result of(final Combination combination, final List<Card> cards) {

		return new Result(combination, cards);
	}

	private Result(final Combination combination, final List<Card> cards) {

		this.combination = combination;
		this.cards = cards;
	}

	public Combination getCombination() {
		return combination;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {

		return "{" + combination + " of " + cards + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		result = prime * result + ((combination == null) ? 0 : combination.hashCode());
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
		final Result other = (Result) obj;
		if (cards == null) {
			if (other.cards != null) {
				return false;
			}
		} else if (!cards.equals(other.cards)) {
			return false;
		}
		if (combination != other.combination) {
			return false;
		}
		return true;
	}




}
