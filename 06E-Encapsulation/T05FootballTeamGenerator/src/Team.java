import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Team {
    private String name;
    private LinkedHashMap<String, Player> players;

    public Team(String name) {
        setName(name);
        players = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty())
            throw new IllegalArgumentException("A name should not be empty.");
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void removePlayer(String playerName) {
        if (!players.containsKey(playerName))
            throw new IllegalArgumentException(String.format(
                    "Player %s is not in %s team.", playerName, name));
        players.remove(playerName);
    }

    public double getRating() {
        if (players.size() == 0) return 0;

        double rating = 0;
        for (double currentRating : players.values().stream()
                .map(Player::overallSkillLevel).collect(Collectors.toList())) {
            rating += currentRating;
        }
        return rating / players.size();
    }

    public String toString() {
        return String.format("%s - %.0f", name, getRating());
    }
}
