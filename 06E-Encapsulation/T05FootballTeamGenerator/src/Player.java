public class Player {
    private String name;
    private int endurance, sprint, dribble, passing, shooting;

    public Player(String name, int endurance, int sprint,
                  int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty())
            throw new IllegalArgumentException("A name should not be empty.");
        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkStat("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkStat("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkStat("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkStat("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkStat("Shooting", shooting);
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private void checkStat(String stat, int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(stat + " should be between 0 and 100.");
        }
    }
}
