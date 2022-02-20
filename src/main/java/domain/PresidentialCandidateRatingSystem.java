package domain;

public class PresidentialCandidateRatingSystem {
    private static int MAX_POINTS = 100;

    public static int calcCandidatePoints(Candidate candidate) {
        int points = 0;
        for (Characteristics characteristic: candidate.getCharacteristics()) {
            points += characteristic.getPoints();
        }
        return Math.min(points, MAX_POINTS);
    }

    public static CandidateRating getCandidateRating(Candidate candidate) {
        int candidatePoints = calcCandidatePoints(candidate);

        if (candidatePoints >= CandidateRating.BRILLIANT.getThreshold()) {
            return CandidateRating.BRILLIANT;
        }

        if (candidatePoints >= CandidateRating.GOOD.getThreshold()) {
            return CandidateRating.GOOD;
        }

        if (candidatePoints >= CandidateRating.NOT_BAD.getThreshold()) {
            return CandidateRating.NOT_BAD;
        }

        if (candidatePoints >= CandidateRating.MEDIOCRE.getThreshold()) {
            return CandidateRating.MEDIOCRE;
        }

        return CandidateRating.BAD;
    }
}
