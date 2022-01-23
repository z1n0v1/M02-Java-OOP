import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Team> teams = new LinkedHashMap<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] data = input.split("\\;");
            switch (data[0]) {
                case "Team": {
                    String teamName = data[1];
                    if(!teams.containsKey(teamName)) {
                        teams.put(teamName, new Team(teamName));
                    }
                    break;
                }
                case "Add": {
                    String teamName = data[1];
                    if(!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        String playerName = data[2];
                        int endurance = Integer.parseInt(data[3]);
                        int sprint = Integer.parseInt(data[4]);
                        int dribble = Integer.parseInt(data[5]);
                        int passing = Integer.parseInt(data[6]);
                        int shooting = Integer.parseInt(data[7]);
                        try {
                            teams.get(teamName).addPlayer(new Player(
                                    playerName, endurance, sprint, dribble, passing, shooting));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case "Remove": {
                    String teamName = data[1];
                    if(!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        try {
                            String playerName = data[2];
                            teams.get(teamName).removePlayer(playerName);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case "Rating": {
                    String teamName = data[1];
                    if(!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        System.out.println(teams.get(teamName));
                    }
                }

            }
        }

    }
}
