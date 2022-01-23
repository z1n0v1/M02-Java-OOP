import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    void addRepair(Repair repair);
    public Collection<Repair> getRepairs();
}
