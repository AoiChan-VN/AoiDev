package aoichan.crystal.engine.roll;

import java.util.Random;

public class ForgeRoll {

    private static final Random random = new Random();

    // [!] Code: Roll success rate
    public static boolean roll(double successRate) {

        double roll = random.nextDouble() * 100;

        return roll <= successRate;
    }
}
