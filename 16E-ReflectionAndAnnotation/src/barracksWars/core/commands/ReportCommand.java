package barracksWars.core.commands;

import barracksWars.anotations.Inject;
import barracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;
    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
