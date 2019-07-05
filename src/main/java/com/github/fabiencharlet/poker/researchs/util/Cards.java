package com.github.fabiencharlet.poker.researchs.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.github.fabiencharlet.poker.researchs.domain.cards.Color;
import com.github.fabiencharlet.poker.researchs.domain.cards.Result;
import com.github.fabiencharlet.poker.researchs.domain.cards.Value;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

public class Cards {

	public enum Combination {

		HIGH_CARD,
		ONE_PAIR,
		TWO_PAIRS,
		THREE_OF_A_KIND,
		STRAIGHT,
		FLUSH,
		FULL_HOUSE,
		FOUR_OF_A_KIND,
		STRAIGHT_FLUSH,
		ROYAL_FLUSH,
	}

	public static boolean areSuited(final Card... cards) {

		for (int i = 1; i < cards.length; i++) {

			if (cards[i].color != cards[0].color) {

				return false;
			}
		}

		return true;
	}

	public static boolean arePair(final Card first, final Card second) {

		return first.value == second.value;
	}

	public static Result findHighestCombination(final List<Card> hand, final List<Card> flop) {

		final List<Card> allCards = new ArrayList<>();
		allCards.addAll(hand);
		allCards.addAll(flop);

		final Optional<Result> bestSameCardResult = findSameCards(allCards);
		final Optional<Result> bestFlushResult = findFlushs(allCards);
		final Optional<Result> bestStraightResult = findStraights(allCards);

		final Optional<Result> bestCombination = Arrays.asList(bestSameCardResult, bestFlushResult, bestStraightResult).stream()
			.filter(Optional::isPresent)
			.map(Optional::get)
			.sorted(Comparator.comparing(Result::getCombination).reversed())
			.findFirst();

		return bestCombination.orElse(Result.highCard(highest(allCards)));
	}

	public static Optional<Result> findSameCards(final List<Card> cards) {

		final ListMultimap<Value, Card> cardsByValue = Multimaps.index(cards, Card::getValue);
		Result bestThree = null;
		Result bestPair = null;
		Result secondBestPair = null;

		// We iterate valies lower to higher, so latest value is the highest
		for (final Value value : Value.values()) {

			final List<Card> sameCards = cardsByValue.get(value);

			if (sameCards.size() == 4) {

				// We won't have better than 4, return directly to simplify
				return Optional.of(Result.of(Combination.FOUR_OF_A_KIND, sameCards));
			}

			if (sameCards.size() == 3) {

				if (bestThree != null) {

					// a lower three can be used as a pair for full house
					bestPair = Result.onePair(bestThree.cards.get(0), bestThree.cards.get(1));
				}

				bestThree = Result.of(Combination.THREE_OF_A_KIND, sameCards);
			}

			if (sameCards.size() == 2) {

				if (bestPair != null) {

					// a lower three can be used as a pair for full house
					secondBestPair = bestPair;
				}

				bestPair = Result.of(Combination.ONE_PAIR, sameCards);
			}
		}

		if (bestThree != null && bestPair != null) {

			final List<Card> fullCards = new ArrayList<Card>();

			fullCards.addAll(bestThree.cards);
			fullCards.addAll(bestPair.cards);
			return Optional.of(Result.of(Combination.FULL_HOUSE, fullCards));
		}

		if (bestThree != null) {

			return  Optional.of(bestThree);
		}

		if (bestPair != null && secondBestPair != null) {

			final List<Card> twoPairsCards = new ArrayList<Card>();

			twoPairsCards.addAll(bestPair.cards);
			twoPairsCards.addAll(secondBestPair.cards);
			return Optional.of(Result.of(Combination.TWO_PAIRS, twoPairsCards));
		}

		if (bestPair != null) {

			return  Optional.of(bestPair);
		}

		return Optional.empty();
	}

	public static Optional<Result> findFlushs(final List<Card> cards) {

		final ListMultimap<Color, Card> cardsByColor = Multimaps.index(cards, Card::getColor);

		for (final Color color : Color.values()) {

			final List<Card> sameColorCards = cardsByColor.get(color);

			if (sameColorCards.size() >= 5) {

				return Optional.of(Result.flush(
						sameColorCards.get(0),
						sameColorCards.get(1),
						sameColorCards.get(2),
						sameColorCards.get(3),
						sameColorCards.get(4)));
			}
		}

		return Optional.empty();
	}

	public static Optional<Result> findStraights(final List<Card> cards) {

		final List<Card> cardsInOrder = cards.stream()
			.sorted(Comparator.comparing(Card::getValue)).collect(Collectors.toList());

		int bestStart = -1;

		for (int i = 0; i < cardsInOrder.size()-4; i++) {

			for (int j = i+4; j < cardsInOrder.size(); j++) {

				final Card firstCard = cardsInOrder.get(i);

				Value currentValue = firstCard.value;
				final Card lastCard = cardsInOrder.get(j);

				if (firstCard.getValue().ordinal() < Value.JACK.ordinal() && lastCard.getValue() == Value.values()[i+4]) {

					for (int index = i+1; index < j+1; index++) {

						if (cardsInOrder.get(index).value != Value.values()[currentValue.ordinal()+1]) {

							continue;
						}

						currentValue = cardsInOrder.get(index).value;
					}

					if (currentValue.ordinal() == firstCard.value.ordinal()+4) {

						bestStart = i;
					}
				}
			}
		}

		if (bestStart > -1) {

			Value current = cardsInOrder.get(bestStart).value;
			final List<Card> straightCards = new ArrayList<Card>();
			straightCards.add(cardsInOrder.get(bestStart));

			for (int i = bestStart+1; i < cardsInOrder.size(); i++) {

				final Card followingCard = cardsInOrder.get(i);
				final Value followingCardValue = followingCard.value;

				if (followingCardValue == current) {

					continue;
				}

				current = followingCardValue;
				straightCards.add(followingCard);

				if (straightCards.size() == 5) {

					break;
				}
			}


			return Optional.of(Result.of(Combination.STRAIGHT, straightCards));
		}

		return Optional.empty();
	}

	public static Card highest(final List<Card> cards) {

		Card highest = cards.get(0);

		for (int i = 1; i < cards.size(); i++) {

			if (cards.get(i).value.getIntValue() > highest.value.getIntValue()) {

				highest = cards.get(i);
			}
		}

		return highest;
	}

}
