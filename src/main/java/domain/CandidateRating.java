package domain;

public enum CandidateRating {
    BRILLIANT(90),
    GOOD(70),
    NOT_BAD(50),
    MEDIOCRE(25),
    BAD(0);

    private final int threshold;

    CandidateRating(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }
}
