package barracksWars.core;

import barracksWars.anotations.Inject;
import barracksWars.core.commands.Command;
import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME =
            "barracksWars.core.commands.";
    private final Repository repository;
    private final UnitFactory unitFactory;


    public CommandInterpreterImpl(Repository repository, UnitFactory factory) {
        this.repository = repository;
        this.unitFactory = factory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String commandClass = COMMANDS_PACKAGE_NAME +
                Character.toUpperCase(commandName.toCharArray()[0]) +
                commandName.substring(1) + "Command";
        try {
            Class<?> clazz = Class.forName(commandClass);
            Constructor<?> constructor = clazz.getConstructor(String[].class);
            Command command = (Command) constructor.newInstance((new Object[]{data}));
            injectDependency(command);
            return command;

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException ex) {
            throw new IllegalArgumentException(commandName + " not implemented");
        }
    }

    private void injectDependency(Command command) throws IllegalAccessException {
        Field[] fields = command.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.getAnnotation(Inject.class) != null) {
                if(field.getType().getSimpleName().equals(Repository.class.getSimpleName())) {
                    field.setAccessible(true);
                    field.set(command, repository);
                } else if(field.getType().getSimpleName().equals(UnitFactory.class.getSimpleName())) {
                    field.setAccessible(true);
                    field.set(command, unitFactory);
                }
            }
        }
    }
}
