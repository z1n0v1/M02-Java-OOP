package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Field[] fields = RichSoilLand.class.getDeclaredFields();
        Field[] result;

        String input;
        while (!"HARVEST".equals(input = reader.readLine())) {
            switch (input) {
                case "private":
                    result = getFieldsByModifier(fields, Modifier::isPrivate);
                    break;
                case "protected":
                    result = getFieldsByModifier(fields, Modifier::isProtected);
                    break;
                case "public":
                    result = getFieldsByModifier(fields, Modifier::isPublic);
                    break;
                default:
                    result = fields;
            }
            Arrays.stream(result).forEach(Main::printField);
        }

    }

    public static void printField(Field field) {
        System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
    }

    private static Field[] getFieldsByModifier(Field[] fields, Predicate<Integer> predicate) {
        return Arrays.stream(fields).filter(f -> predicate.test(f.getModifiers())).toArray(Field[]::new);

    }


}
