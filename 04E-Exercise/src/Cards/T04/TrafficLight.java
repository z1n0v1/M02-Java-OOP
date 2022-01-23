package Cards.T04;

public enum TrafficLight {
    GREEN, YELLOW, RED;

    public TrafficLight next() {
        if(this == GREEN)
            return YELLOW;
        if(this == YELLOW)
            return RED;
        return GREEN;
    }
}
