package de.unistuttgart.hamster.examples;

import de.unistuttgart.hamster.facade.Ladybug;
import de.unistuttgart.hamster.main.SimpleHamsterGame;

public class Example02 extends SimpleHamsterGame {
    public static void main(final String[] args) {
        createInstance(Example02.class);
    }

    Ladybug paula;

    /**
     * Another hamster program. The idea is to create Paula close to Paula with
     * grain in her mouth. She drops it and Paule picks it up.
     */
    @Override
    protected void run() {
        displayInNewGameWindow();

        paula = new Ladybug(game.getTerritory(), kara.getLocation(), kara.getDirection());
        paula.move();
        paula.move();

        kara.move();
        kara.turnLeft();
        kara.turnLeft();
        kara.move();
    }
}
