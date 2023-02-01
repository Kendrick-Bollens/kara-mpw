package de.unistuttgart.hamster.examples;

import de.unistuttgart.hamster.main.SimpleHamsterGame;

public class Example01 extends SimpleHamsterGame {
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
            kara.write("Hallo!");
            kara.move();
            kara.putClover();
            kara.move();
            kara.turnLeft();
            kara.turnLeft();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.turnLeft();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.turnLeft();
            kara.turnLeft();
            kara.move();
            kara.pickClover();
            kara.turnLeft();
            kara.move();
            kara.turnLeft();
            kara.turnLeft();
            kara.turnLeft();
        }
    }

}
