package com.github.fabiencharlet.poker.researchs.util;

import java.util.Arrays;

import org.junit.Test;

import com.github.fabiencharlet.poker.researchs.domain.cards.Card;
import com.github.fabiencharlet.poker.researchs.domain.cards.Result;
import com.google.common.truth.Truth;

public class CardCombinationsTest {

	@Test
	public void noCombinationShallBeHighCard() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.five().ofHeart()),
				Arrays.asList(Card.seven().ofDiamond(),Card.ten().ofClub(),Card.eight().ofDiamond(),Card.jack().ofSpade(),Card.four().ofClub())))

			 .isEqualTo(Result.highCard(Card.jack().ofSpade()));
	}

	@Test
	public void onePairShallBeFound() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.three().ofHeart()),
				Arrays.asList(Card.seven().ofDiamond(),Card.ten().ofClub(),Card.eight().ofDiamond(),Card.three().ofSpade(),Card.four().ofClub())))

		 	.isEqualTo(Result.onePair(Card.three().ofHeart(), Card.three().ofSpade()));

	}

	@Test
	public void twoPairsShallBeFound() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.ten().ofSpade(),Card.three().ofHeart()),
				Arrays.asList(Card.seven().ofDiamond(),Card.ten().ofClub(),Card.eight().ofDiamond(),Card.three().ofSpade(),Card.four().ofClub())))

		.isEqualTo(Result.twoPairs(Card.ten().ofSpade(), Card.ten().ofClub(), Card.three().ofHeart(), Card.three().ofSpade()));
	}

	@Test
	public void threeOfAKindShallBeFound() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.three().ofHeart()),
				Arrays.asList(Card.seven().ofDiamond(),Card.three().ofClub(),Card.eight().ofDiamond(),Card.three().ofSpade(),Card.four().ofClub())))

		 	.isEqualTo(Result.threeOfAKind(Card.three().ofHeart(), Card.three().ofClub(), Card.three().ofSpade()));
	}

	@Test
	public void fourOfAKindShallBeFound() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.three().ofHeart()),
				Arrays.asList(Card.three().ofDiamond(),Card.three().ofClub(),Card.eight().ofDiamond(),Card.three().ofSpade(),Card.four().ofClub())))

		 	.isEqualTo(Result.fourOfAKind(Card.three().ofHeart(), Card.three().ofDiamond(),Card.three().ofClub(),Card.three().ofSpade()));
	}

	@Test
	public void fullHouseShallBeFound() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.three().ofHeart()),
				Arrays.asList(Card.two().ofDiamond(),Card.three().ofClub(),Card.eight().ofDiamond(),Card.three().ofSpade(),Card.two().ofClub())))

		 	.isEqualTo(Result.fullHouse(Card.three().ofHeart(), Card.three().ofClub(), Card.three().ofSpade(),Card.two().ofSpade(),Card.two().ofDiamond()));
	}

	@Test
	public void flushShallBeHighCard() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.five().ofSpade()),
				Arrays.asList(Card.seven().ofSpade(),Card.ten().ofClub(),Card.eight().ofSpade(),Card.jack().ofSpade(),Card.four().ofClub())))

			 .isEqualTo(Result.flush(Card.two().ofSpade(),Card.five().ofSpade(),Card.seven().ofSpade(),Card.eight().ofSpade(),Card.jack().ofSpade()));
	}

	@Test
	public void straightShallBeHighCard() {

		Truth.assertThat(
			Cards.findHighestCombination(
				Arrays.asList(Card.two().ofSpade(),Card.five().ofHeart()),
				Arrays.asList(Card.seven().ofDiamond(),Card.three().ofClub(),Card.six().ofDiamond(),Card.jack().ofSpade(),Card.four().ofClub())))

			 .isEqualTo(Result.straight(Card.three().ofClub(),Card.four().ofClub(),Card.five().ofHeart(),Card.six().ofDiamond(),Card.seven().ofDiamond()));
	}
}
