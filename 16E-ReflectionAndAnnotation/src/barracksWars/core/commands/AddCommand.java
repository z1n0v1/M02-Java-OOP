package barracksWars.core.commands;

import barracksWars.anotations.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class AddCommand extends Command{
        @Inject
        UnitFactory unitFactory;
        @Inject
        Repository repository;
    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            Unit unitToAdd = unitFactory.createUnit(unitType);
            repository.addUnit(unitToAdd);
            return unitType + " added!";
        } catch (ExecutionControl.NotImplementedException e) {
//            e.printStackTrace();
            return e.getMessage();
        }
    }
}
