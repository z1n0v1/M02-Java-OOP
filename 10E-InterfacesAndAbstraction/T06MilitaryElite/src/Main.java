import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Private> privates = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] command = input.split("\\s+");
            int id = Integer.parseInt(command[1]);
            String firstName = command[2];
            String lastName = command[3];
            switch (command[0]) {
                case "Private": {
                    double salary = Double.parseDouble(command[4]);
                    Private priv = new PrivateImpl(id, firstName, lastName, salary);
                    privates.put(id, priv);
                    System.out.println(priv);
                    break;
                }
                case "LieutenantGeneral": {
                    double salary = Double.parseDouble(command[4]);
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
//                    privates.put(id, lieutenantGeneral);
                    for (int i = 5; i < command.length; i++) {
                        int privateId = Integer.parseInt(command[i]);
                        lieutenantGeneral.addPrivate(privates.get(privateId));
                    }
                    System.out.println(lieutenantGeneral);
                    break;
                }
                case "Engineer": {
                    double salary = Double.parseDouble(command[4]);
                    if(!isValidCorps(command[5])) break;
                    Corps corps = Corps.valueOf(command[5]);
                    Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
//                    privates.put(id, engineer);
                    for (int i = 6; i < command.length; i+=2) {
                        String repairPart = command[i];
                        int repairHours = Integer.parseInt(command[i + 1]);
                        engineer.addRepair(new Repair(repairPart, repairHours));
                    }
                    System.out.println(engineer);
                    break;
                }
                case "Commando": {
                    double salary = Double.parseDouble(command[4]);
                    if(!isValidCorps(command[5])) break;
                    Corps corps = Corps.valueOf(command[5]);
                    Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);
//                    privates.put(id, commando);
                    for (int i = 6; i < command.length; i+=2) {
                        String missionCodeName = command[i];
                        if(!isValidMissionState(command[i + 1])) continue;
                        MissionState missionState = MissionState.valueOf(command[i + 1]);
                        commando.addMission(new Mission(missionCodeName, missionState));
                    }
                    System.out.println(commando);
                    break;
                }
                case "Spy": {
                    String codeNumber = command[4];
                    Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.println(spy);
                }
            }
        }
    }

    private static boolean isValidMissionState(String missionState) {
        return missionState.equals(MissionState.inProgress.toString()) ||
                missionState.equals(MissionState.finished.toString());
    }

    private static boolean isValidCorps(String corps) {
        return corps.equals(Corps.Airforces.toString()) || corps.equals(Corps.Marines.toString());
    }
}
