package de.unistuttgart.hamster.examples;

import de.unistuttgart.hamster.facade.Hamster;
import de.unistuttgart.hamster.main.SimpleHamsterGame;

public class Example02 extends SimpleHamsterGame {
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
