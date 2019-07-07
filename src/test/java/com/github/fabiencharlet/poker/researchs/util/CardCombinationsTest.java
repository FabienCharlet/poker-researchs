package com.github.fabiencharlet.poker.researchs.util;

import java.util.Arrays;

import org.junit.Test;

import com.github.fabiencharlet.poker.researchs.TestsBase;
import com.github.fabiencharlet.poker.researchs.domain.cards.Result;
import com.google.common.truth.Truth;

public class CardCombinationsTest extends TestsBase {

	@Test
	public void noCombinationShallBeHighCard() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(), five().ofHeart()),
				Arrays.asList(seven().ofDiamond(), ten().ofClub(), eight().ofDiamond(), jack().ofSpade(),four().ofClub())))

			 .isEqualTo(Result.highCard(jack().ofSpade()));
	}

	@Test
	public void onePairShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),three().ofHeart()),
				Arrays.asList(seven().ofDiamond(),ten().ofClub(),eight().ofDiamond(),three().ofSpade(),four().ofClub())))

		 	.isEqualTo(Result.onePair(three().ofHeart(), three().ofSpade()));

	}

	@Test
	public void twoPairsShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(ten().ofSpade(),three().ofHeart()),
				Arrays.asList(seven().ofDiamond(),ten().ofClub(),eight().ofDiamond(),three().ofSpade(),four().ofClub())))

		.isEqualTo(Result.twoPairs(ten().ofSpade(), ten().ofClub(), three().ofHeart(), three().ofSpade()));
	}

	@Test
	public void threeOfAKindShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),three().ofHeart()),
				Arrays.asList(seven().ofDiamond(),three().ofClub(),eight().ofDiamond(),three().ofSpade(),four().ofClub())))

		 	.isEqualTo(Result.threeOfAKind(three().ofHeart(), three().ofClub(), three().ofSpade()));
	}

	@Test
	public void fourOfAKindShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),three().ofHeart()),
				Arrays.asList(three().ofDiamond(),three().ofClub(),eight().ofDiamond(),three().ofSpade(),four().ofClub())))

		 	.isEqualTo(Result.fourOfAKind(three().ofHeart(), three().ofDiamond(),three().ofClub(),three().ofSpade()));
	}

	@Test
	public void fullHouseShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),three().ofHeart()),
				Arrays.asList(two().ofDiamond(),three().ofClub(),eight().ofDiamond(),three().ofSpade(),two().ofClub())))

		 	.isEqualTo(Result.fullHouse(three().ofHeart(), three().ofClub(), three().ofSpade(),two().ofSpade(),two().ofDiamond()));
	}

	@Test
	public void flushShallBeHighFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),five().ofSpade()),
				Arrays.asList(seven().ofSpade(),ten().ofClub(),eight().ofSpade(),jack().ofSpade(),four().ofClub())))

			 .isEqualTo(Result.flush(two().ofSpade(),five().ofSpade(),seven().ofSpade(),eight().ofSpade(),jack().ofSpade()));
	}

	@Test
	public void straightShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),five().ofHeart()),
				Arrays.asList(seven().ofDiamond(),three().ofClub(),six().ofDiamond(),jack().ofSpade(),four().ofClub())))

			 .isEqualTo(Result.straight(three().ofClub(),four().ofClub(),five().ofHeart(),six().ofDiamond(),seven().ofDiamond()));
	}

	@Test
	public void straightAceToFiveShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(two().ofSpade(),five().ofHeart()),
				Arrays.asList(ace().ofDiamond(),three().ofClub(),queen().ofDiamond(),jack().ofSpade(),four().ofClub())))

			 .isEqualTo(Result.straight(ace().ofDiamond(),two().ofSpade(),three().ofClub(),four().ofClub(),five().ofHeart()));
	}

	@Test
	public void straightWithThreeOfAKindShallBeStraight() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(three().ofSpade(),five().ofHeart()),
				Arrays.asList(seven().ofDiamond(),three().ofClub(),six().ofDiamond(),three().ofHeart(),four().ofClub())))

			 .isEqualTo(Result.straight(three().ofSpade(),four().ofClub(),five().ofHeart(),six().ofDiamond(),seven().ofDiamond()));
	}

	@Test
	public void straightFlushShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(three().ofSpade(),five().ofClub()),
				Arrays.asList(seven().ofClub(),three().ofClub(),six().ofClub(),five().ofSpade(),four().ofClub())))

			 .isEqualTo(Result.straightFlush(three().ofClub(),four().ofClub(),five().ofClub(),six().ofClub(),seven().ofClub()));
	}

	@Test
	public void royalFlushShallBeFound() {

		Truth.assertThat(
			Combinations.findHighestCombination(
				Arrays.asList(ace().ofSpade(),queen().ofClub()),
				Arrays.asList(ace().ofClub(),ten().ofClub(),king().ofClub(),queen().ofSpade(),jack().ofClub())))

			 .isEqualTo(Result.royalFlush(ten().ofClub(),jack().ofClub(),queen().ofClub(),king().ofClub(),ace().ofClub()));
	}
}
