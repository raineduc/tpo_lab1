package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static domain.CandidateRating.*;
import static domain.Characteristics.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PresidentialCandidateRatingSystemTest {

    @Test
    void zeroCharacteristics() {
        Candidate candidate = new Candidate("name", List.of());
        assertEquals(0, PresidentialCandidateRatingSystem.calcCandidatePoints(candidate));
        assertEquals(BAD, PresidentialCandidateRatingSystem.getCandidateRating(candidate));
    }

    @Test
    void hundredPointsLimit() {
        Candidate candidate = new Candidate("name", List.of(KNOWLEDGE_OF_GALAXY, FIFTHY_POINTS));
        assertEquals(100, PresidentialCandidateRatingSystem.calcCandidatePoints(candidate));
        assertEquals(BRILLIANT, PresidentialCandidateRatingSystem.getCandidateRating(candidate));
    }

    @ParameterizedTest
    @MethodSource("oneCharacteristicSource")
    void oneCharacteristic(Characteristics characteristic, CandidateRating candidateRating) {
        Candidate candidate = new Candidate("name", List.of(characteristic));
        assertEquals(characteristic.getPoints(), PresidentialCandidateRatingSystem.calcCandidatePoints(candidate));
        assertEquals(candidateRating, PresidentialCandidateRatingSystem.getCandidateRating(candidate));
    }

    @ParameterizedTest
    @MethodSource("multipleCharacteristicsSource")
    void multipleCharacteristics(List<Characteristics> characteristics, int points, CandidateRating candidateRating) {
        Candidate candidate = new Candidate("name", characteristics);
        assertEquals(points, PresidentialCandidateRatingSystem.calcCandidatePoints(candidate));
        assertEquals(candidateRating, PresidentialCandidateRatingSystem.getCandidateRating(candidate));
    }

    static Stream<Arguments> oneCharacteristicSource() {
        return Stream.of(
                Arguments.arguments(TEN_POINTS, BAD),
                Arguments.arguments(CHARISMA, MEDIOCRE),
                Arguments.arguments(FIFTHY_POINTS, NOT_BAD),
                Arguments.arguments(SEVENTY_POINTS, GOOD),
                Arguments.arguments(KNOWLEDGE_OF_GALAXY, BRILLIANT)
        );
    }

    static Stream<Arguments> multipleCharacteristicsSource() {
        return Stream.of(
                Arguments.arguments(List.of(TEN_POINTS, FIVE_POINTS), 15, BAD),
                Arguments.arguments(List.of(TWENTY_POINTS, FIVE_POINTS), 25, MEDIOCRE),
                Arguments.arguments(List.of(FIFTHY_POINTS, FIVE_POINTS, FIVE_POINTS), 60, NOT_BAD),
                Arguments.arguments(List.of(FIFTHY_POINTS, CHARISMA), 80, GOOD),
                Arguments.arguments(List.of(KNOWLEDGE_OF_GALAXY, FIVE_POINTS), 95, BRILLIANT)
        );
    }
}
