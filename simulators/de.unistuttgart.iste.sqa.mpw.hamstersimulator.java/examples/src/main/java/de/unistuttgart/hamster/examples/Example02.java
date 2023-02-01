package de.unistuttgart.hamster.examples;

import de.unistuttgart.hamster.facade.Hamster;
import de.unistuttgart.hamster.main.Example;
import de.unistuttgart.hamster.main.SimpleHamsterGame;

public class Example02 extends SimpleHamsterGame {
    public Example02() {
        super(Example.EXAMPLE_2);
    }

    public static void main(final String[] args) {
        createInstance(Example02.class);
    }

    Hamster paula;

    @Override
    protected void run() {
        displayInNewGameWindow();

        paula = new Hamster(game.getTerritory(), kara.getLocation(), kara.getDirection());
        paula.move();
        kara.putClover();
        paula.putClover();
        paula.move();

        kara.move();
        kara.turnLeft();
        kara.turnLeft();
        kara.move();
    }
}
