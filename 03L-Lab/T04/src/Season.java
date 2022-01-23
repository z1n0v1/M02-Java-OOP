public enum Season {
    Spring(2), Summer(4), Autumn(1), Winter(3);

    private final int season;

    Season(int season) {
        this.season = season;
    }

    public int getValue() {
        return season;
    }
}
