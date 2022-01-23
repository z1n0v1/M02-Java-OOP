package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int AXE_ATTACK = 8;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_HEALTH =  DUMMY_HEALTH - AXE_ATTACK;

    Axe axe;
    Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void dummyLosesHealthWhenAttacked() {

        axe.attack(dummy);

        Assert.assertEquals("Wrong Health, ", EXPECTED_HEALTH, dummy.getHealth());

    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyAttacked() {

        axe.attack(dummy);
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyGivesXP() {

        axe.attack(dummy);
        axe.attack(dummy);

        Assert.assertEquals("Wrong Dummy XP, ", DUMMY_XP, dummy.giveExperience());
    }

    @Test (expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {

        dummy.giveExperience();
    }
}
