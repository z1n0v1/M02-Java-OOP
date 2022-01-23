package T01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            Class<Reflection> clazz = Reflection.class;
            System.out.println(clazz);
            System.out.println(clazz.getSuperclass());
            for (Class cl : clazz.getInterfaces())
                System.out.println(cl);
            Object o = clazz.getDeclaredConstructor().newInstance();

            System.out.println(o);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
