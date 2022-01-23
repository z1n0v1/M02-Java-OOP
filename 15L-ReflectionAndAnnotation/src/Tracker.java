import java.lang.reflect.Method;
import java.util.*;

public class Tracker {

    @Author(name = "Pesho")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);

    }

    @Author(name = "Gosho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new LinkedHashMap<>();

        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if(annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }
        methodsByAuthor.forEach((authorName, authoredMethods) -> {
            System.out.printf("Author: %s%n", authorName);
            authoredMethods.forEach(methodName -> {
                System.out.printf(" - %s%n", methodName);
            });
        });
    }
}
