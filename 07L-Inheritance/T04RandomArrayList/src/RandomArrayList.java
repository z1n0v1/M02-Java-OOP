import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement() {
        Random random = new Random();
        int rndElement = random.nextInt(this.size());
        return this.remove(rndElement);
    }
}
