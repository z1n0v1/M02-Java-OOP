package T02;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        try {

            Method[] methods = Reflection.class.getDeclaredMethods();
            Method[] getters = Arrays.stream(methods).filter(m ->
                    m.getName().startsWith("get") && m.getParameterCount() == 0)
                    .sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
            Method[] setters = Arrays.stream(methods).filter(m ->
                    m.getName().startsWith("set") && m.getParameterCount() == 1)
                    .sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
            Arrays.stream(getters).forEach(m -> {
                System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName());
            });
            Arrays.stream(setters).forEach(m -> {
                System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName());
            });

/*
            Class<Reflection> clazz = Reflection.class;
            Map<String, String> getters = new TreeMap<String, String>();
            Map<String, String> setters = new TreeMap<String, String>();

            for (Method method : clazz.getMethods()) {

                String methodName = method.getName();
                if (methodName.startsWith("get")) {
                    String returnType = method.getReturnType().getSimpleName();
                    getters.put(methodName, returnType);
                } else if (methodName.startsWith("set")) {
                    String fieldType = method.getParameterTypes()[0].getName();
                    setters.put(methodName, fieldType);
                }
            }
            getters.forEach((name, returnType) -> {
                System.out.printf("%s will return class %s%n", name, returnType);
            });
            setters.forEach((name, parameterType) -> {
                System.out.printf("%s and will set field of class %s%n", name, parameterType);
            });

*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
