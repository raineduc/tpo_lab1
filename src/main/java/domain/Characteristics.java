package domain;

public enum Characteristics {
    KNOWLEDGE_OF_GALAXY(90),
    CHARISMA(30),
    FIVE_POINTS(5),
    TEN_POINTS(10),
    TWENTY_POINTS(20),
    THIRTY_POINTS(30),
    FOURTY_POINTS(40),
    FIFTHY_POINTS(50),
    SEVENTY_POINTS(70);



    private final int points;

    Characteristics(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
