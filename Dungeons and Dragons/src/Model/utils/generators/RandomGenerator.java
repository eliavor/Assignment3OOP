package Model.utils.generators;

import java.util.Random;

public class RandomGenerator implements Generator{

    private Random random;


    public RandomGenerator() {
        this.random = new Random();
    }

    public RandomGenerator(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public int generate(int value) {
        return random.nextInt(value);
    }
}
