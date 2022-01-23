package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {
    private final int TARGET_XP = 10;
    private final int WEAPON_ATTACK_POINTS = 10;
    private final String HERO_NAME = "Gosho";

    private Hero hero;
    private Weapon fakeWeapon;
    private Target fakeTarget;

    @Before
    public void initializeTestObjects() {
        this.fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        this.fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return WEAPON_ATTACK_POINTS;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

        this.hero = new Hero(HERO_NAME, fakeWeapon);
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {

        Target mockitoTarget = Mockito.mock(Target.class);
        Mockito.when(mockitoTarget.isDead()).thenReturn(true);
        Mockito.when(mockitoTarget.giveExperience()).thenReturn(TARGET_XP);
        this.hero.attack(mockitoTarget);

        Assert.assertEquals("Wrong experience, ", TARGET_XP, hero.getExperience());
    }
}
