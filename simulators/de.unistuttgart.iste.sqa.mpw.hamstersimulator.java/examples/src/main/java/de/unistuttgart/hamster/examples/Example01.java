package de.unistuttgart.hamster.examples;

import de.unistuttgart.hamster.main.Example;
import de.unistuttgart.hamster.main.SimpleHamsterGame;

public class Example01 extends SimpleHamsterGame {
    public Example01() {
        super(Example.EXAMPLE_1);
    }

    public static void main(final String[] args) {
        createInstance(Example01.class);
    }

    /**
     * How often Paule should repeat its behaviour.
     */
    private static final int SCENARIO_REPETITION_COUNT = 200000;

    @Override
    protected void run() {
        displayInNewGameWindow();
        for (int i = 0; i < SCENARIO_REPETITION_COUNT; i++) {
            kara.move();
            kara.move();
            kara.putClover();
            kara.move();
            kara.move();
            kara.turnRight();
            kara.move();
            kara.turnRight();
            kara.move();
            kara.move();
            kara.turnRight();
            kara.move();
            kara.pickClover();
            kara.turnLeft();
            kara.move();
            kara.move();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.turnLeft();
        }
    }

}
