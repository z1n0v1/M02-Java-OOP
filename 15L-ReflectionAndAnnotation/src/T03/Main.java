package T03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
/*
        Field[] fields = Reflection.class.getDeclaredFields();
        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] methods = Reflection.class.getDeclaredMethods();
        Arrays.stream(methods).filter(m -> m.getName().startsWith("get") &&
                !Modifier.isPublic(m.getModifiers())).sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be public!%n", m.getName()));
        Arrays.stream(methods).filter(m -> m.getName().startsWith("set") &&
                        !Modifier.isPrivate(m.getModifiers())).sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be private!%n", m.getName()));
*/
/*        Field[] fields = Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
//                .filter(f -> (f.getModifiers() & Modifier.PRIVATE) == 0)
                .sorted(Comparator.comparing(Field::getName)).toArray(Field[]::new);
//        System.out.println("For Fields:");
        for (Field f : fields)
            System.out.println(f.getName() + " must be private!");

        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods).filter(m -> m.getName().startsWith("get")
                && !Modifier.isPublic(m.getModifiers()))
//                && (m.getModifiers() & Modifier.PUBLIC) == 0)
                .sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
//        System.out.println("For Getters:");
        for (Method m : getters)
            System.out.println(m.getName() + " must be public!");

        Method[] setters = Arrays.stream(methods).filter(m -> m.getName().startsWith("set")
                        && !Modifier.isPrivate(m.getModifiers()))
//                        && (m.getModifiers() & Modifier.PRIVATE) == 0)
                .sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
//        System.out.println("For Setters:");
        for (Method m : setters)
            System.out.println(m.getName() + " must be private!");

 */
    }
}
