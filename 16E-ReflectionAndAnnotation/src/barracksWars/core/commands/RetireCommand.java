package barracksWars.core.commands;

import barracksWars.anotations.Inject;
import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{
    @Inject
    Repository repository;
    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            repository.removeUnit(getData()[1]);
        } catch (ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
        return getData()[1] + " retired!";
    }
}
